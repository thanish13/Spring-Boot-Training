package com.example.demo.api.impl;

import com.example.demo.api.OauthApi;
import org.springframework.security.core.Authentication;

public class OauthApiImpl implements OauthApi {

    @Override
    public String publicEndpoint() {
        return "Public Endpoint";
    }

    @Override
    public String secureEndpoint(Authentication authentication) {
        return "Hello, " + authentication.getName() + "! You accessed a secure endpoint.";
    }
}