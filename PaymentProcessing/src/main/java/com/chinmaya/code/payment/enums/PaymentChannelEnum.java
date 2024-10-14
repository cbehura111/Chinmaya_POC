package com.chinmaya.code.payment.enums;

import com.chinmaya.code.payment.service.impl.CreditCardPayment;
import com.chinmaya.code.payment.service.impl.PayPalPayment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Map;

@AllArgsConstructor
public enum PaymentChannelEnum {
    CREDIT_CARD(CreditCardPayment.class.getSimpleName()),
    DEBIT_CARD("DEBIT_CARD bean name"),
    PAYPAL(PayPalPayment.class.getSimpleName()),
    GPay("GPay"),
    BANK_TRANSFER("BANK_TRANSFER");

    private final String channelBean;

    public String getChannelBean() {
        return channelBean.substring(0, 1).toLowerCase() + channelBean.substring(1);
    }
}
