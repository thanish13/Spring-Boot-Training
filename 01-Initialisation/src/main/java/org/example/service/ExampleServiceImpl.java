package org.example.service;


import org.example.api.Example;
import org.springframework.stereotype.Component;

@Component
public class ExampleServiceImpl implements Example {

    @Override
    public String getExample(String name){
        return "Hello " + name;
    }
}
