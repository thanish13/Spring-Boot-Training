package org.example.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.Response;
import org.example.api.OauthApi;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;


@Component
public class OauthApiImpl implements OauthApi {

    @Override
    public Response login() {
        return Response.accepted().entity("login").build();
    }

    @Override
    public Response home(HttpServletRequest request) {
        return Response.accepted().entity("home").build();

    }
}