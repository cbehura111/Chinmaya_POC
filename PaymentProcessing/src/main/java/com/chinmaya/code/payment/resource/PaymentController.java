package com.chinmaya.code.payment.resource;

import com.chinmaya.code.payment.dto.PaymentRequestData;
import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.service.core.IPaymentService;
import com.chinmaya.utils.payload.core.Header;
import com.chinmaya.utils.payload.core.Response;
import com.chinmaya.utils.payload.core.ResponseWrapper;
import com.chinmaya.utils.utils.CommonUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/payments/${app.version}")
@Tag(name = "Payments Processing Controller")
@AllArgsConstructor
@Slf4j
public class PaymentController {
private final IPaymentService iPaymentService;
    @ApiOperation(value = "Process Payments", notes = "API to process various payments through channels")
    @PostMapping(value = "/process"/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public BaseResponse processPayment(@Valid  @RequestBody PaymentRequestData paymentData){
        return iPaymentService.processPayment(paymentData);
    }

    private BaseResponse buildBaseResponse(JSONObject jsonResponse, int statusCode) {
        var baseResponse = new BaseResponse();
        baseResponse.setData(jsonResponse);
        baseResponse.setHttpStatusCode(statusCode);
        return baseResponse;
    }
    @ApiResponses({
            @ApiResponse(responseCode = "200", description= "AppzillonBanking API reachable"),
            @ApiResponse(responseCode = "408", description= "Service Timed Out"),
            @ApiResponse(responseCode = "500", description= "Internal Server Error"),
            @ApiResponse(responseCode = "404", description= "AppzillonBanking not reachable") })
    @Operation(summary = "User Dispute", description = "API for User Dispute")
    @GetMapping(value = "/fetch-block-channel",produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<ResponseWrapper>> fetchBlockChannel(@RequestHeader(defaultValue = "APZRMB") String appId,
                                                                                           @RequestHeader(defaultValue = "00000015022081009") String userId,
                                                                                           @RequestHeader(defaultValue = "12345678") String masterTxnRefNo,
                                                                                           @RequestHeader(defaultValue = "APZabcd1234efgh5678RMB") String deviceId) {
        log.warn("Start : Fetch Block Channel details");
        String interfaceId= "UserEnquiry";
        Header header = CommonUtils.obtainHeader(appId, interfaceId, userId, masterTxnRefNo, deviceId);
        Mono<Response> response = iPaymentService.fetchBlockChannel(header);

        return response.flatMap(val -> {
            ResponseWrapper responseWrapper = ResponseWrapper.builder().apiResponse(val).build();
            return Mono.just(new ResponseEntity<>(responseWrapper, HttpStatus.OK));
        });
    }
}
