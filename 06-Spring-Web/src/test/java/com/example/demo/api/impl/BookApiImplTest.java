package com.example.demo.api.impl;

import com.example.demo.entity.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BookApiImplTest {

    @InjectMocks
    BookApiImpl bookApi = new BookApiImpl();

    @Mock
    BookRepository repository;

    @Test
    public void postCall() {

        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity<?> response = bookApi.getAllBooks();

        assertEquals(response.getStatusCode(), HttpStatusCode.valueOf(200));

    }

}