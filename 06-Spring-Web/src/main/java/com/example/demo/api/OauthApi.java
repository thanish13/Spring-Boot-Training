package com.example.demo.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface OauthApi {

    @GetMapping("/public")
    public String publicEndpoint();

    @GetMapping("/secure")
    public String secureEndpoint(Authentication authentication);
}