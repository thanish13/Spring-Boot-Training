package org.example.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

@Path("/oauth")
public interface OauthApi {

    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    Response login();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    Response home(OAuth2AuthenticationToken token);
}
