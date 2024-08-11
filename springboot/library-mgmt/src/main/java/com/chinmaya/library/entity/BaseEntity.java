package com.chinmaya.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

    @Column(name = "CREATE_TS", length = 100, nullable = false)
    private LocalDateTime createTs;

    @Column(name = "CREATE_BY", length = 100, nullable = false)
    private String createBy;

    @Column(name = "ACTIVE" ,length = 1, nullable = false)
    private String active;

//    @Column(name = "MAKER_ID", length = 100, nullable = false)
//    private String makerId;
//
//    @Column(name = "MAKER_TS", length = 100, nullable = false)
//    private LocalDateTime makerTs;
//
//    @Column(name = "CHECKER_ID", length = 100)
//    private String checkerId;
//
//    @Column(name = "CHECKER_TS", length = 100)
//    private LocalDateTime checkerTs;
//
//    @Column(name = "AUTH_STATUS" ,length = 1, nullable = false)
//    private String authStatus;
//
//    @Column(name = "ACTION", length = 3, nullable = false)
//    private String action;
}
