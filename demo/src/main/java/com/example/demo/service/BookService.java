package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;

public class BookService {
    @Autowired
    BookRepo bookRepo;

    Book getBookById(Integer id) {
        return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    Book getBookByTitle(String title) {
        return bookRepo.findByBookName(title).orElseThrow(() -> new RuntimeException("Book not found"));
    }
}
