package com.example.demo.controller;

import com.example.demo.entity.BookRepository;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private BookRepository repository;

    @QueryMapping
    public List<Book> allBooks() {
        return repository.findAll();
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return repository.getReferenceById(Long.valueOf(id));
    }

    @MutationMapping
    public Book addBook(@Argument int id, @Argument String title, @Argument String author, @Argument String category) {
        return repository.save(new Book(id,title,author,category));
    }

}