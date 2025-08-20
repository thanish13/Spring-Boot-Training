package com.example.demo.api.impl;

import com.example.demo.api.BookApi;
import com.example.demo.entity.BookRepository;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BookApiImpl implements BookApi {

    @Autowired
    BookRepository repository;

    @Override
    public ResponseEntity<?> getAllBooks() {

        return ResponseEntity.ok(repository.findAll());
    }

    @Override
    public ResponseEntity<?> getBookById(Long id) {

        return ResponseEntity.ok(repository.getReferenceById(id));
    }

    @Override
    public ResponseEntity<?> createBook(Book book) {
        repository.saveAndFlush(book);
        return ResponseEntity.ok("Created");
    }

    @Override
    public ResponseEntity<?> updateBook(Long id, Book book) {
        Book oldBook = repository.findById(id).stream().findFirst().stream().toList().get(0);
        oldBook = book;
        repository.saveAndFlush(oldBook);
        return ResponseEntity.ok("Updated");
    }

    @Override
    public ResponseEntity<?> deleteBook(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
