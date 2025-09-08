package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class GatewayApp {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(GatewayApp.class);
    }
}