package com.chinmaya.code.payment.enums;

public enum AuthStatus {
    AUTHORISE("A"),
    UN_AUTHORISE("U"),
    REJECT("R");

    private final String authorisationStatus;

    // Constructor
    AuthStatus(String authorisationStatus) {
        this.authorisationStatus = authorisationStatus;
    }

    // Getter method
    public String getAuthorisationStatus() {
        return authorisationStatus;
    }
}
