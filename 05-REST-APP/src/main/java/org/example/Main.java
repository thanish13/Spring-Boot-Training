package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Enable scheduling
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(Main.class);
    }
}