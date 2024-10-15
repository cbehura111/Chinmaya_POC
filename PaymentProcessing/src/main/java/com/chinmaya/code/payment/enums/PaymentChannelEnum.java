package com.chinmaya.code.payment.enums;

import com.chinmaya.code.payment.service.core.impl.CreditCardPayment;
import com.chinmaya.code.payment.service.core.impl.PayPalPayment;
import com.chinmaya.code.payment.service.core.impl.UpiPayment;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PaymentChannelEnum {
    CREDIT_CARD(CreditCardPayment.class.getSimpleName()),
    DEBIT_CARD("DEBIT_CARD bean name"),
    PAYPAL(PayPalPayment.class.getSimpleName()),
    UPI_PAYMENT(UpiPayment.class.getSimpleName()),
    BANK_TRANSFER("BANK_TRANSFER");

    private final String channelBean;

    public String getChannelBean() {
        return channelBean.substring(0, 1).toLowerCase() + channelBean.substring(1);
    }
}
