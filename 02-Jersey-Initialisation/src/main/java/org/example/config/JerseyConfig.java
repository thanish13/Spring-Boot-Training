package org.example.config;

import jakarta.ws.rs.ApplicationPath;
import org.example.service.ExampleImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    private JerseyConfig() {
        registerClasses(ExampleImpl.class);
    }
}