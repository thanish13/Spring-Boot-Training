package org.example;

import org.example.service.ExampleServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@EnableAutoConfiguration
@Import(ExampleServiceImpl.class)
public class Main  extends SpringBootServletInitializer {

    public static void main(String[] args) {

        System.out.println("Hello world!");
        new SpringApplicationBuilder(Main.class)
                .run(args);
    }
}