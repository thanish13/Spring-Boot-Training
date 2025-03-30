package org.example.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.ext.Provider;
import org.example.api.Example;
import org.example.service.ExampleServiceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/resources")
@Provider
@Configuration
public class AppConfig extends ResourceConfig {

    public void Config(){
        register(ExampleServiceImpl.class);
        register(Example.class);
    }

}