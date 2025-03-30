package org.example.config;

import jakarta.ws.rs.ApplicationPath;
import org.example.api.Example;
import org.example.service.ExampleServiceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/resources")
public class RestConfig extends ResourceConfig {

    public void Config(){
        register(ExampleServiceImpl.class);
        register(Example.class);
    }

}