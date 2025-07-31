package com.example.demo.api.impl;

import com.example.demo.api.BookApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookApiImpl implements BookApi {

    @Override
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> getBookById(Long id) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> createBook(Object book) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> updateBook(Long id, Object book) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deleteBook(Long id) {
        return ResponseEntity.ok().build();
    }
}
