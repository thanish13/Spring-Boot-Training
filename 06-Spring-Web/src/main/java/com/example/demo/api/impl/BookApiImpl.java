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
        repository.findAll();
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> getBookById(Long id) {
        repository.getReferenceById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> createBook(Book book) {
        repository.saveAndFlush(book);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> updateBook(Long id, Book book) {
        Book oldBook = repository.findById(id).stream().findFirst().stream().toList().get(0);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deleteBook(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
