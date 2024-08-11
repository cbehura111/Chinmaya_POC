package com.chinmaya.library.service;

import com.chinmaya.library.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    public List<Book> findAllBooks();

    public List<Book> searchBooks(String keyword);

    public Book findBookById(Long id);

    public Map<String, String> createBook(List<Book> books);

    public void updateBook(Book book);

    public void deleteBook(Long id);
}
