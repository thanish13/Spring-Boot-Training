package com.example.demo.controller;

import com.example.demo.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {

    @QueryMapping
    public List<Book> allBooks() {
        return List.of(new Book("1","",""));
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return new Book("1","","");
    }

    @MutationMapping
    public Book addBook(@Argument String title, @Argument String author) {
        return new Book("1",title, author);
    }
}