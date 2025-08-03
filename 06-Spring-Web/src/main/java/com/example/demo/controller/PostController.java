package com.example.demo.controller;

import com.example.demo.model.Post;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {

    @QueryMapping
    public List<Post> recentPosts(@Argument int count, @Argument int offset) {
        return null;
    }
}