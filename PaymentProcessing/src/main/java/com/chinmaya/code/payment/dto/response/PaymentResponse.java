package com.chinmaya.code.payment.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
public class PaymentResponse {
    private String transactionCurrency;
    private BigDecimal transactionAmount;
    private String paymentChannel;
    private String paymentDetails;
}
