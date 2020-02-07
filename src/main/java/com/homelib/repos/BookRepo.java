package com.homelib.repos;

import com.homelib.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByIsbn(String isbn);
}
