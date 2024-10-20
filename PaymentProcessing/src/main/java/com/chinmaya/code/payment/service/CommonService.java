package com.chinmaya.code.payment.service;

import com.chinmaya.code.payment.dto.PaymentRequestData;
import com.chinmaya.code.payment.dto.response.ApiResponse;
import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.enums.PaymentIntegratorEnum;
import com.chinmaya.code.payment.enums.SuccessCodes;
import com.chinmaya.code.payment.mapper.IResponseMapper;
import com.chinmaya.code.payment.service.integrator.IGatewayIntegrator;
import com.chinmaya.code.payment.utils.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class CommonService {
    @Autowired
    IResponseMapper responseMapper;
    @Autowired
    Utility utility;
    @Autowired
    private Map<String,IGatewayIntegrator> gatewayIntegratorBeans;
    /**
     * @param paymentData
     * @param receiptId
     * @return BaseResponse
     */
    public BaseResponse executePayment(PaymentRequestData paymentData, String receiptId) {
        String paymentGateway = paymentData.getPaymentIntegrator() != null ? paymentData.getPaymentIntegrator().getPaymentGateway() : PaymentIntegratorEnum.RAZOR_PAY.getPaymentGateway();
        IGatewayIntegrator gatewayIntegrator = gatewayIntegratorBeans.get(paymentGateway);
        if (gatewayIntegrator == null) {
            throw new IllegalArgumentException("Unsupported payment gateway: " + paymentData.getPaymentIntegrator());
        }
        ApiResponse apiResponse = gatewayIntegrator.createPaymentOrder(paymentData.getAmount(), receiptId, HttpMethod.GET, "/getBankParams");
        paymentData.setPaymentId(utility.extractTransactionId(apiResponse.getResponseBody()));
        var paymentResponse = responseMapper.toPaymentResponse(paymentData);
        return utility.formSuccessResponse(apiResponse.getStatusCode(), SuccessCodes.SUCCESS_SAVE, utility.getJsonNode(paymentResponse));
    }
}
