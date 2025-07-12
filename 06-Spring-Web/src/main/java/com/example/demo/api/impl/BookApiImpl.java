package com.example.demo.api.impl;

import com.example.demo.api.BookApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookApiImpl implements BookApi {

    @Override
    public ResponseEntity<?> postCall() {
        return ResponseEntity.ok("API");
    }
}
