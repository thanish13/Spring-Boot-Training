package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class ServerApp {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(ServerApp.class);
    }
}