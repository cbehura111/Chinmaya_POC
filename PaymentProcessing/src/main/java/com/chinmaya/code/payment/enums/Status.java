package com.chinmaya.code.payment.enums;

public enum Status {
    S("SUCCESS"),
    F("FAIL"),
    Y("YES"),
    N("NO"),
    P("PENDING"),
    R("REJECT"),
    I("INITIATE");

    private final String statusCode;

    // Constructor
    Status(String statusCode) {
        this.statusCode = statusCode;
    }

    // Getter method
    public String getStaus() {
        return statusCode;
    }
}
