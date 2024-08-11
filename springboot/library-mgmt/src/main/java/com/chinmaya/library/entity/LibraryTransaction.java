package com.chinmaya.library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "LM_LIBRARY_TXN")
@Data
public class LibraryTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueId;

    @Column(name = "BOOK_ID", length = 100, nullable = false)
    private Long bookId;

    @Column(name = "ISSUED_BY", length = 100, nullable = false)
    private String issuedBy;

    @Column(name = "ISSUED_ON", length = 100, nullable = false)
    private LocalDateTime issuedOn;

    @Column(name = "ISSUED_TO", length = 100, nullable = false)
    private String issuedTo;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "DUE_DATE", length = 10, nullable = false)
    private String dueDate;

    @Column(name = "ISSUE_STATUS", length = 6, nullable = false)
    private String issueStatus;
}
