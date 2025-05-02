package com.example.api;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

/**
* Represents a collection of functions to interact with the API endpoints.
*/
@Path("/users")
@Api(description = "the users API")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2025-05-02T22:20:34.297152100+05:30[Asia/Calcutta]", comments = "Generator version: 7.12.0")
public class UsersApi {

    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Returns a list of users.", notes = "Optional extended description in CommonMark or HTML.", response = String.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A JSON array of user names", response = String.class, responseContainer = "List")
    })
    public Response usersGet() {
        return Response.ok().entity("magic!").build();
    }
}
