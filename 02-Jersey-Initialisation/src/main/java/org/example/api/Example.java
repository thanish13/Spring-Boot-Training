package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/example")
public interface Example {

    @GET
    @Path("/get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getName(@PathParam("name") String name);

}
