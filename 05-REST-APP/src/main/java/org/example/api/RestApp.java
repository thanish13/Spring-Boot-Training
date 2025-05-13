package org.example.api;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/rest")
public interface RestApp {

    @Path("/getRequest")
    @GET
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiResponse
    Response getRequest();
}
