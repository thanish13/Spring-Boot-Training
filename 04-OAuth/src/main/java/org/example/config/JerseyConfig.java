package org.example.config;

import jakarta.ws.rs.ApplicationPath;
import org.example.service.OauthApiImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Component
@ApplicationPath("api")
@EnableWebMvc
public class JerseyConfig extends ResourceConfig {

    private JerseyConfig() {
        registerClasses(OauthApiImpl.class);
    }
}