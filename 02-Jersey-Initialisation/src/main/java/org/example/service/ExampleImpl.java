package org.example.service;

import jakarta.ws.rs.core.Response;
import org.example.api.Example;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLEngineResult;

@Component
public class ExampleImpl implements Example{

    @Override
    public Response getName(String name) {
        return Response.status(Response.Status.OK).entity("Get " + name ).build();
    }

    @Override
    public Response postName(String name) {
        return Response.status(Response.Status.CREATED).entity("Post " + name ).build();
    }

    @Override
    public Response updateName(String name) {
        return Response.status(Response.Status.ACCEPTED).entity("Update " + name ).build();
    }

    @Override
    public Response deleteName(String name) {
        return Response.status(Response.Status.OK).entity("Delete " + name ).build();
    }
}
