package com.chinmaya.code.payment.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -9079454849611061074L;

    private final String errorCode;
    private final List<ErrorList> errorMessage;

    public ResourceNotFoundException(List<ErrorList> errorMessage, final String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public ResourceNotFoundException(String format, final String errorCode) {
        super(format);
        this.errorCode = errorCode;
        this.errorMessage = null;
    }
}
