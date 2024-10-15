package com.chinmaya.code.payment.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Setter
@Getter
public class InternalServerException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1096705945921813339L;
    private final String errorCode;

    public InternalServerException(String format, final String errorCode) {
        super(format);
        this.errorCode = errorCode;
    }
}