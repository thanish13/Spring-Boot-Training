package org.example.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.model.Body;

@Path("/myresource")
    @Tag(name = "My Resource", description = "Operations related to My Resource")
    public class MyResource {
        @GET
        @Produces(MediaType.APPLICATION_JSON)g
        @Operation(summary = "Get data", description = "Returns some data")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Body.class))),
                @ApiResponse(responseCode = "404", description = "Not found")
        })
        public Response getData() {
            return Response.ok("MY DATA").build();
        }
    }