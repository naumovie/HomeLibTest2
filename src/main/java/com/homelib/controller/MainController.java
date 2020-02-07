package com.homelib.controller;

import com.homelib.model.Book;
import com.homelib.model.User;
import com.homelib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
   @Autowired
   private BookService bookService;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/")
    public String main(@AuthenticationPrincipal User user,
                       Model model) {
        Iterable<Book> books = bookService.findAll();

        model.addAttribute("books",books);
        return "main";
    }






}
