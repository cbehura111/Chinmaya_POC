package com.chinmaya.code.payment.service;

import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.dto.PaymentRequestData;
import com.chinmaya.code.payment.dto.response.PaymentResponse;

public interface IPaymentService {
    PaymentResponse processPayment(PaymentRequestData paymentData);
    BaseResponse initiatePayment(PaymentRequestData paymentData);
    BaseResponse deletePayment(PaymentRequestData paymentData);
}
