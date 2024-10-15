package com.chinmaya.code.payment.enums;

import lombok.*;

@AllArgsConstructor
@Getter
public enum SuccessCodes {
    SUCCESS_SAVE("Transaction saved successfully"),
    SUCCESS_FETCH_LIST("Successfully fetched list of Transaction"),
    SUCCESS_FETCH("Successfully fetched Transaction"),
    SUCCESS_FETCH_TXN("Successfully fetched completed Transaction"),
    SUCCESS_UPDATE("Transaction update initiated successfully"),
    SUCCESS_UPDATE_AUTH("Transaction updated and saved successfully"),
    SUCCESS_DEL("Transaction delete initiated successfully"),
    SUCCESS_DEL_AUTH("Transaction delete initiated and saved successfully"),
    SUCCESS_AUTHORISE("Transaction authorised successfully"),
    SUCCESS_INTERMEDIATE_APPROVE("Intermediate Approved and pending with other checkers"),
    SUCCESS_REJECT("Transaction rejected successfully");
    private final String successMessage;
}
