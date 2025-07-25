package com.example.demo.api.impl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class BookApiImplTest {

    @InjectMocks
    BookApiImpl bookApi = new BookApiImpl();

    @Test
    public void postCall() {

        ResponseEntity<?> response = bookApi.postCall();

        assertEquals(response.getStatusCode(), HttpStatusCode.valueOf(200));

    }

}