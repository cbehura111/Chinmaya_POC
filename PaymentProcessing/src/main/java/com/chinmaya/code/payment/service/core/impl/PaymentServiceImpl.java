package com.chinmaya.code.payment.service.core.impl;

import com.chinmaya.cache.interfaceAdapter.service.InterfaceAdapter;
import com.chinmaya.cache.interfaceAdapter.utils.AdapterUtil;
import com.chinmaya.cache.payload.core.*;
import com.chinmaya.cache.utils.CommonUtils;
import com.chinmaya.cache.utils.CommonUtilsCBS;
import com.chinmaya.cache.utils.CustomDynamicValue;
import com.chinmaya.code.config.IdGenerator;
import com.chinmaya.code.payment.dto.request.GenericRequest;
import com.chinmaya.code.payment.dto.request.GenericRequestFields;
import com.chinmaya.code.payment.dto.request.UserEnquiryRequest;
import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.dto.PaymentRequestData;
import com.chinmaya.code.payment.service.core.IPaymentService;
import com.chinmaya.code.payment.service.core.IPaymentStrategy;
import com.chinmaya.code.payment.utils.EncryptionDecryption;
import com.chinmaya.code.payment.utils.FisdomEncDecUtils;
import com.chinmaya.utils.constants.CommonConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private Map<String, IPaymentStrategy> paymentStrategies;

    private final IdGenerator idGenerator;

    private final CommonUtilsCBS commonUtilsCBS;

    private final InterfaceAdapter interfaceAdapter;

    private final AdapterUtil adapterUtil;

    /**
     * @param paymentData
     */
    @Override
    public BaseResponse processPayment(PaymentRequestData paymentData) {
            IPaymentStrategy iPaymentStrategy = paymentStrategies.get(paymentData.getPaymentChannel().getChannelBean());  // card number
        if(iPaymentStrategy == null) {
            throw new IllegalArgumentException("Unsupported payment method: " + paymentData.getPaymentDetails());
        }
        return iPaymentStrategy.pay(paymentData, String.valueOf(idGenerator.nextId()));

    }

    /**
     * @param paymentData
     */
    @Override
    public BaseResponse initiatePayment(PaymentRequestData paymentData) {
    return null;
    }

    /**
     * @param paymentData
     */
    @Override
    public BaseResponse deletePayment(PaymentRequestData paymentData) {
        return null;
    }

    @Override
    @CircuitBreaker(name = "fallback", fallbackMethod = "fetchBlockChannelFallback")
    @Transactional(rollbackFor = Exception.class)
    public Mono<Response> fetchBlockChannel(Header header) {
        try {
            JSONObject dataObj = new JSONObject();
            var requestId = commonUtilsCBS.generateReqId(header.getUserId(), 10);
            dataObj.put("userId", FisdomEncDecUtils.formatAccountNumber(header.getUserId(), 6, false));
            dataObj.put("requestType", header.getInterfaceId());
            dataObj.put("requestId", requestId);
            log.debug("data before encryption :: {}", dataObj);

            // Step2: Encrypt the generated /translated request data
            String dataEncryptedString = CustomDynamicValue.encrypt(dataObj.toString());
            log.debug("data after encryption :: " + dataEncryptedString);
            UserEnquiryRequest requestObj = UserEnquiryRequest.builder()
                    .requestId(requestId)
                    .reqTimestamp(String.valueOf(Instant.now().toEpochMilli()))
                    .data(dataEncryptedString)
                    .build();

            ObjectMapper mapperObj = new ObjectMapper();
            String strData = mapperObj.writeValueAsString(requestObj);
            String checkSum = EncryptionDecryption.generateSHA256Hash(strData);

            requestObj.setChksum(checkSum);

            // Step3: Frame Generic BOM API Request Parameters
            GenericRequestFields genericRequestFields = GenericRequestFields.builder().requestId(requestId)
                    .data(dataEncryptedString).build();
            log.debug("generic Request :: " + genericRequestFields);

            GenericRequest genericRequest = GenericRequest.builder().appId(header.getAppId())
                    .userId(header.getUserId()).interfaceName(header.getInterfaceId())
                    .requestObj(genericRequestFields).build();
            var interfaceName = header.getInterfaceId();

            log.debug("Final request before service call :: {}", genericRequest);

            return this.getMonoResponse(header, genericRequest, interfaceName);
        } catch (Exception e) {
            log.error("Exception Occurred:: {}", e);
            ResponseHeader responseHeader = new ResponseHeader();
            CommonUtils.generateHeaderForGenericError(responseHeader);
            Response response = Response.builder().responseHeader(responseHeader).responseBody(null).build();
            return Mono.just(response);
        }
    }
    private Mono<Response> getMonoResponse(Header header, GenericRequest genericRequest, String interfaceName) {
        Mono<Object> fetchBlockChannelResponse = interfaceAdapter.callExternalService(header, genericRequest,
                interfaceName, true);

        Mono<ResponseWrapper> fetchBlockChannelRes = adapterUtil.generateRespWrapper(fetchBlockChannelResponse,
                interfaceName, header, true);

        return fetchBlockChannelRes.flatMap(val -> {
            if (CommonConstants.SUCCESS
                    .equalsIgnoreCase(val.getApiResponse().getResponseHeader().getResponseCode())) {

                String resObj = val.getApiResponse().getResponseBody().getResponseObj();
                JSONObject finalAPIResponse = new JSONObject(resObj);

                ResponseHeader responseHeader = ResponseHeader.builder().responseCode(CommonConstants.SUCCESS)
                        .responseMessage("").build();
                ResponseBody responseBody = ResponseBody.builder().responseObj(finalAPIResponse.toString()).build();
                Response response = Response.builder().responseHeader(responseHeader).responseBody(responseBody)
                        .build();
                return Mono.just(response);
            } else {
                ResponseHeader responseHeader = new ResponseHeader();
                CommonUtils.generateHeaderForGenericError(responseHeader);
                Response response = Response.builder().responseHeader(responseHeader).responseBody(null).build();
                return Mono.just(response);
            }
        });
    }
}
