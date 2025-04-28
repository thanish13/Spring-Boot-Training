package org.example.config;

import jakarta.ws.rs.ApplicationPath;
import org.example.service.RestAppImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/app")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(RestAppImpl.class);
    }


}
