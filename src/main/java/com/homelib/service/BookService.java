package com.homelib.service;

import com.homelib.model.Book;
import com.homelib.model.Genre;
import com.homelib.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    public Iterable<Book> findAll() {
        return bookRepo.findAll();
    }


    public boolean add(Book book) {
        if (StringUtils.isEmpty(book.getTitle())) {
            return false;
        }

        book.setGenres(Collections.singleton(Genre.DRAMA));

        return true;
    }
}
