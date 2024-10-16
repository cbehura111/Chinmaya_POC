package com.chinmaya.code.payment.dto;

import com.chinmaya.code.payment.enums.PaymentChannelEnum;
import com.chinmaya.code.payment.enums.PaymentIntegratorEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestData implements Serializable {
    @Hidden
    private String paymentId ;

    @NotBlank(message = "Transaction currency cannot be null/empty")
    @Schema(example = "INR")
    private String txnCurrency;

    @NotBlank(message = "Transaction amount cannot be null/empty")
    @Schema(example = "10,000.00")
    private BigDecimal amount;

    @NotBlank(message = "Payment channel cannot be null/empty")
    @Schema(example = "GPay")
    private PaymentChannelEnum paymentChannel;

    @NotBlank(message = "Payment Gateway cannot be null/empty")
    @Schema(example = "RAZOR_PAY")
    private PaymentIntegratorEnum paymentIntegrator;

    @NotBlank(message = "paymentDetails channel cannot be null/empty")
    @Schema(example = "1068061107")
    private String paymentDetails;
}
