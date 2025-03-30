package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class ExampleServiceImpl {

    public String getExample(int id){
        return "Hello";
    }
}
