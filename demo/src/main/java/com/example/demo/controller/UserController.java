package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.repo.BookRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserServiceImpl;


import org.springframework.ui.Model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
public class UserController {
    
     @Autowired 
     UserRepo userRepo;

     @Autowired
     UserServiceImpl userServiceImpl;


     @Autowired
     BookRepo bookRepo;

    @GetMapping("/shop")
    public String shop(Model model) {
        List<Book> books = bookRepo.findAll();
         model.addAttribute("books", books);
        return "shop";   // shop.html
    }


   @GetMapping("/myBooks")
    public String myBooks(Model model, Principal principal) {
        String email = principal.getName();
        User user = userRepo.findByEmail(email).orElse(null);
        if (user == null) {
            return "redirect:/login";
        }
        Set<Book> booksSet = user.getPurchasedBooks();
        List<Book> books = new ArrayList<>(booksSet);

        Collections.sort(books, (a, b) -> Integer.compare(a.getId(), b.getId()));
        model.addAttribute("books", books);
        return "myBooks";
    }


    @GetMapping("/buy/{bookId}")
    public String buyBook(@PathVariable int bookId, Principal principal) {

        String email = principal.getName();
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        user.getPurchasedBooks().add(book);
        userRepo.save(user);
        return "redirect:/myBooks";
    }

    @GetMapping("/myBooks/read/{id}")
    public String readBook(@PathVariable int id, Model model) {
        Book book = bookRepo.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "bookContent";   // bookContent.html
    }


  @GetMapping("/myBooks/remove/{bookId}")
    public String removeBook(@PathVariable int bookId, Principal principal) {
        String email = principal.getName();
        User user = userRepo.findByEmail(email)
                            .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = bookRepo.findById(bookId)
                            .orElseThrow(() -> new RuntimeException("Book not found"));

        user.getPurchasedBooks().remove(book);

        userRepo.save(user);
        return "redirect:/myBooks";
    }

    



}