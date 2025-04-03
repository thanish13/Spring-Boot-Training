package org.example.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/example")
public interface Example {

    @GET
    @Path("/get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getName(@PathParam("name") String name);

    @POST
    @Path("/get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    Response postName(@PathParam("name") String name);

    @PUT
    @Path("/get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    Response updateName(@PathParam("name") String name);

    @DELETE
    @Path("/get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    Response deleteName(@PathParam("name") String name);

}
