package org.example;

import org.example.config.RestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RestConfig.class)
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world!");
        SpringApplication.run(Main.class, args);

    }
}