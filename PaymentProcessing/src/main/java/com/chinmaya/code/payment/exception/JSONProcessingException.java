package com.chinmaya.code.payment.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JSONProcessingException extends RuntimeException {

    private static final long serialVersionUID = -9079454849611061074L;

    private final String errorCode;
    private final List<ErrorList> errorMessage;

    public JSONProcessingException(List<ErrorList> errorMessage, final String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public JSONProcessingException(String format, final String errorCode) {
        super(format);
        this.errorCode = errorCode;
        this.errorMessage = null;
    }
}