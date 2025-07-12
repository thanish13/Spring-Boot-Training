package org.example.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.concurrent.ExecutionException;

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

    @Path("/asyncRequest")
    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation
    Response asyncRequest() throws JsonProcessingException, ExecutionException, InterruptedException;

    @Path("/execRequest")
    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation
    Response execRequest() throws JsonProcessingException, ExecutionException, InterruptedException;
}

