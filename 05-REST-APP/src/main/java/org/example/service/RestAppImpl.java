package org.example.service;

import jakarta.ws.rs.core.Response;
import org.example.api.RestApp;
import org.springframework.stereotype.Component;

@Component
public class RestAppImpl implements RestApp {

    @Override
    public Response getRequest() {

        return Response.accepted().entity("j  ").build();
    }
}
