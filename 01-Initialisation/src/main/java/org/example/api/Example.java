package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/example")
public class Example{

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExample(@PathParam("id") String id){
        return Response.status(200).entity(getExample(id)).build();
    }



}
