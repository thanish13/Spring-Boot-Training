package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class ExampleServiceImpl {

    public String getExample(String name){
        return "Hello" + name;
    }
}
