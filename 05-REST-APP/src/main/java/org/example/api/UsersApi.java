package org.example.api;

import org.example.model.Body;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

/**
* Represents a collection of functions to interact with the API endpoints.
*/
@Path("/users")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2025-05-18T21:38:20.308106600+05:30[Asia/Calcutta]", comments = "Generator version: 7.12.0")
public interface UsersApi {

    /**
     * Optional extended description in CommonMark or HTML.
     *
     * @param body Optional description in *Markdown*
     * @return A JSON array of user names
     */
    @GET
    @Path("/decrypt")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Returns a list of users.", description = "Optional extended description in CommonMark or HTML." )
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200" , description = "A JSON array of user names"  )
    })
    Response usersDecryptGet(@Valid @NotNull Body body);

    /**
     * Optional extended description in CommonMark or HTML.
     *
     * @return A JSON array of user names
     */
    @GET
    @Path("/encrypt")
    @Produces({ "application/json" })
    @Operation(summary = "Returns a list of users.", description = "Optional extended description in CommonMark or HTML." )
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200" , description = "A JSON array of user names"  )
    })
    Response usersEncryptGet();
}
