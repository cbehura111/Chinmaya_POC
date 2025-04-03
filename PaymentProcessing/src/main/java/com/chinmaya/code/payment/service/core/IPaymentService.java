package com.chinmaya.code.payment.service.core;

import com.chinmaya.utils.payload.core.Header;
import com.chinmaya.utils.payload.core.Response;
import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.dto.PaymentRequestData;
import reactor.core.publisher.Mono;

public interface IPaymentService {
    BaseResponse processPayment(PaymentRequestData paymentData);
    BaseResponse initiatePayment(PaymentRequestData paymentData);
    BaseResponse deletePayment(PaymentRequestData paymentData);

    Mono<Response> fetchBlockChannel(Header header);
}
