package com.chinmaya.library.service.impl;

import com.chinmaya.library.config.SequenceGenerator;
import com.chinmaya.library.entity.Book;
import com.chinmaya.library.manager.NotFoundException;
import com.chinmaya.library.repo.BookRepository;
import com.chinmaya.library.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Book> searchBooks(String keyword) {
        if (keyword != null) {
            return bookRepository.search(keyword);
        }
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public Book findBookById(Long isbn) {
        return bookRepository.findById(isbn)
                .orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", isbn)));
    }

    @Override
    public Map<String, String> createBook(List<Book> books) {
        ArrayList<Book> bookList = new ArrayList<>();
        Map<String, String> response = new HashMap<>();
        try {
            for (Book b : books) {
                b.setAvlCopies(b.getTotalCopies());
                bookList.add(b);
            }
            bookRepository.saveAll(bookList);
            response.put("Status", "SUCCESS");
            response.put("msg", "Book(s) added successfully");

        } catch (Exception e) {
            response.put("Status", "FAIL");
            response.put("msg", "Book(s) can not be added");
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(Long id) {

    }
}
