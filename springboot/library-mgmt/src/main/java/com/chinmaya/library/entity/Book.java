package com.chinmaya.library.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "LM_BOOKS")
@Data
@Builder
public class Book extends BaseEntity {
    @Id
    @Column(name = "ISBN", length = 50, nullable = false, unique = true)
    private String isbn;

    @Column(name = "BOOK_NAME", length = 100, nullable = false)
    private String bookName;

    @Column(name = "AUTHOR", length = 250, nullable = false)
    private List<String> author;

    @Column(name = "DESCRIPTION", length = 250, nullable = false)
    private String description;

    @Column(name = "GENRE", length = 250, nullable = false)
    private String genre;

    @Column(name = "PUBLISHED_ON", length = 4, nullable = false)
    private int publishedOn;

    @Column(name = "TOTAL_COPIES", nullable = false)
    private int totalCopies;

    @Column(name = "AVL_COPIES", nullable = false)
    private int avlCopies;

    @Column(name = "EDITION", nullable = false)
    private double edition;

    @Column(name = "PUBLISHER", length = 250, nullable = false)
    private String publisher;
}
