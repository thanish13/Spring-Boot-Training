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
    @Path("/post/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    Response postName(@PathParam("name") String name);

    @PUT
    @Path("/put/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    Response updateName(@PathParam("name") String name);

    @DELETE
    @Path("/delete/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    Response deleteName(@PathParam("name") String name);

}
