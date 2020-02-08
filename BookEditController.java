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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
                      BindingResult bindingResult,
                      Model model,
                      @RequestParam(required = false, name = "file") MultipartFile cover) throws IOException {


        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorMap);
            model.addAttribute("book",book);
            model.addAttribute("message","Book wasnt added, something goes wrong");

        } else {
            if (cover != null && !cover.isEmpty()) {
                File uploadDir = new File(uploadPath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + cover.getOriginalFilename();

                cover.transferTo(new File(uploadPath + "/" + resultFilename));
                book.setCover(resultFilename);
            }
                model.addAttribute("message","Book was succesfully added");
                bookRepo.save(book);

        }


        return "bookedit";
    }




}
