package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class ExampleServiceImpl {

    public Object getExample(String id){
        return "Hello";
    }
}
