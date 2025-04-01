package org.example.service;

import jakarta.ws.rs.core.Response;
import org.example.api.Example;
import org.springframework.stereotype.Component;

@Component
public class ExampleImpl implements Example{

    @Override
    public Response getName(String name) {
        return Response.accepted().entity("Hello " + name ).build();
    }
}
