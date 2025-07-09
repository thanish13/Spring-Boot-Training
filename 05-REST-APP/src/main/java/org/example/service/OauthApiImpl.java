package org.example.service;

import jakarta.ws.rs.core.Response;
import org.example.api.OauthApi;

public class OauthApiImpl implements OauthApi {

    @Override
    public Response home() {
        return Response.accepted().entity("All done").build();
    }

    @Override
    public Response page() {
        return Response.accepted().entity("Page").build();
    }
}
