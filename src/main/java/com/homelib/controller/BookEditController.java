package com.homelib.controller;

import com.homelib.model.Book;
import com.homelib.model.User;
import com.homelib.repos.BookRepo;
import com.homelib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class BookEditController {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private BookService bookService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/bookedit")
    public String bookedit(Model model) {
        return "bookedit";
    }

    @PostMapping("/bookedit")
    public String add(@AuthenticationPrincipal User user,
                      @Valid Book book,
                      Model model,
                      @RequestParam("cover") MultipartFile file) throws IOException {
        bookService.add(book);

        if (file != null && !file.isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));
            book.setCover(resultFilename);

            bookRepo.save(book);
        }


        return "main";
    }



}
