package com.example.demo.controller;

import com.example.demo.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {

    Book book = new Book("1","title","author");

    @QueryMapping
    public List<Book> allBooks() {
        return List.of(book);
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return book;
    }

    @MutationMapping
    public Book addBook(@Argument String id ,@Argument String title, @Argument String author) {
        return new Book(id ,title, author);
    }
}