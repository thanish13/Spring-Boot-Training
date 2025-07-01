package org.example.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/rest")
public interface RestApp {

    @Path("/getRequest")
    @GET
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation
    Response getRequest();

    @Path("/postRequest")
    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation
    Response postRequest(@RequestBody Object body) throws JsonProcessingException;
}
