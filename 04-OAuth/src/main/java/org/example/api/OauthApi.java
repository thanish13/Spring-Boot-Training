package org.example.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.security.access.prepost.PreAuthorize;

@Path("/oauth")
public interface OauthApi {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    Response login();

    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    Response home(HttpServletRequest request);

}
