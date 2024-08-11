package com.chinmaya.library.controller;

import com.chinmaya.library.entity.Book;
import com.chinmaya.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private BookService bookService;

    //    @Autowired
//    private LibraryTxnService libraryTxnService;
//    @Autowired
//    private UserService userService;
    @PostMapping(value = "/book/add", consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, String>> saveBooks(@RequestBody List<Book> books) {
        Map<String, String> res = bookService.createBook(books);
        return new ResponseEntity<>(res, OK);
    }

}
