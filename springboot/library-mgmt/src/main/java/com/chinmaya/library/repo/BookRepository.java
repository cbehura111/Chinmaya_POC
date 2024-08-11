package com.chinmaya.library.repo;

import com.chinmaya.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE LOWER(b.bookName) LIKE %:keyword% OR LOWER(b.isbn) LIKE %:keyword% OR LOWER(b.description) LIKE %:keyword% ")
    public List<Book> search(@Param("keyword") String keyword);
}
