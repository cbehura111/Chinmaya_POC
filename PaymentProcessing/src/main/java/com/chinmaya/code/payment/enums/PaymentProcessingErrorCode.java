package com.chinmaya.code.payment.enums;

public enum PaymentProcessingErrorCode {

    ERR_GENERIC_SERVICE_FAILURE("Payment processing generic failure"),
    ERR_VALIDATION_FAILURE("Payment processing Validation failure"),
    ERR_TXN_LIMIT("Transaction limit out of range minimum : %s and maximum : %s");


    private final String errorMessage;

    // Constructor
    PaymentProcessingErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Getter method
    public String getErrorMessage() {
        return errorMessage;
    }

}
