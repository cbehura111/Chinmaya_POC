package com.chinmaya.code.payment.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Setter
@Getter
public class DuplicateResourceFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -6623698531819954917L;
    private final String errorCode;

    public DuplicateResourceFoundException(String format, final String errorCode) {
        super(format);
        this.errorCode = errorCode;
    }
}
