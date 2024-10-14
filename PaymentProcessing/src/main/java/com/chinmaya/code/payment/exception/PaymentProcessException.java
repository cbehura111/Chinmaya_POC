package com.chinmaya.code.payment.exception;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PaymentProcessException extends RuntimeException {

    private static final long serialVersionUID = -9079454849611061074L;

    private final String errorCode;
    private final String errorMessage;
    private String min;
    private String max;
    private List<String> errorList;

    public PaymentProcessException(String format, final String errorCode) {
        super(format);
        this.errorCode = errorCode;
        this.errorMessage = format;
    }

    public PaymentProcessException(String format, final String errorCode, String min, String max) {
        super(format);
        this.errorCode = errorCode;
        this.errorMessage = format;
        this.min = min;
        this.max = max;
    }

}