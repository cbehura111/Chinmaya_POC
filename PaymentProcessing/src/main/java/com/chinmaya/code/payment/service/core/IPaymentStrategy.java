package com.chinmaya.code.payment.service.core;

import com.chinmaya.code.payment.dto.PaymentRequestData;
import com.chinmaya.code.payment.dto.response.BaseResponse;

public interface IPaymentStrategy {
    BaseResponse pay(PaymentRequestData paymentData, String receiptId);
}
