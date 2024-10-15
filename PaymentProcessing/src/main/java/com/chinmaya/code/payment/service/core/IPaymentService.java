package com.chinmaya.code.payment.service.core;

import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.dto.PaymentRequestData;

public interface IPaymentService {
    BaseResponse processPayment(PaymentRequestData paymentData);
    BaseResponse initiatePayment(PaymentRequestData paymentData);
    BaseResponse deletePayment(PaymentRequestData paymentData);
}
