package org.example.service;

import jakarta.ws.rs.core.Response;
import org.example.api.OauthApi;
import org.springframework.stereotype.Component;


@Component
public class OauthApiImpl implements OauthApi {

    @Override
    public Response login() {
        return Response.accepted().entity("login").build();
    }
}