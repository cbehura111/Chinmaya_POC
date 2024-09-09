package com.chinmaya.code.payment.service;

import com.chinmaya.code.payment.dto.PaymentRequestData;

public interface IPaymentService {
    void processPayment(PaymentRequestData paymentData);
    void initiatePayment(PaymentRequestData paymentData);
    void deletePayment(PaymentRequestData paymentData);
}
