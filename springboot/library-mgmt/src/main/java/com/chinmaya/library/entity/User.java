package com.chinmaya.library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "LM_USERS")
@Data
public class User extends BaseEntity{
    @Id
    @Column(name = "USER_ID", length = 10, nullable = false)
    private String userId;

    @Column(name = "USER_NAME", length = 100, nullable = false)
    private String userName;

    @Column(name = "ROLE", length = 10, nullable = false)
    private String role;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "DOB", length = 10, nullable = false)
    private String dob;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "ENROLLED_ON", length = 10, nullable = false)
    private String enrolledOn;

    @Column(name = "MAX_ISSUE_COUNT")
    private int maxIssueCount;

    @Column(name = "CURRENT_ISSUE_COUNT")
    private int currentIssueCount;

    @Column(name = "IS_AUTHOR")
    private boolean isAuthor;

    //ID Card, Gender
}
