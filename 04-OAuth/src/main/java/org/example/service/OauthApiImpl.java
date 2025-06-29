package org.example.service;

import jakarta.ws.rs.core.Response;
import org.example.api.OauthApi;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;


@Component
public class OauthApiImpl implements OauthApi {

    @Override
    public Response login() {
        return Response.accepted().entity("login").build();
    }

    @Override
    public Response home(OAuth2AuthenticationToken token) {
        return Response.accepted().entity(token.getPrincipal().getAttribute("name")).build();

    }
}