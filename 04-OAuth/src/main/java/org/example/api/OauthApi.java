package org.example.api;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/oauth")
public interface OauthApi {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    Response login();

}
