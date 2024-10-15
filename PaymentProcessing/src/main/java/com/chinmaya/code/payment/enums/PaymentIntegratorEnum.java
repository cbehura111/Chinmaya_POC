package com.chinmaya.code.payment.enums;

import com.chinmaya.code.payment.service.integrator.impl.RazorpayService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PaymentIntegratorEnum {
    RAZOR_PAY(RazorpayService.class.getSimpleName()),
    PHONE_PE("PhonePe bean name"),
    PAYTM("Paytm bean name"),;

    private final String paymentGateway;

    public String getPaymentGateway() {
        return paymentGateway.substring(0, 1).toLowerCase() + paymentGateway.substring(1);
    }
}
