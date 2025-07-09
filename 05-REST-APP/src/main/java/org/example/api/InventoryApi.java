package org.example.api;

import org.example.model.InventoryItem;
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
@Path("/inventory")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2025-07-06T08:02:29.599716600+05:30[Asia/Calcutta]", comments = "Generator version: 7.12.0")
public interface InventoryApi {

    /**
     * 
     *
     * @return List of inventory items
     */
    @GET
    @Operation(summary = "Get all inventory items", description = "" )
    Response inventoryGet();

    /**
     * 
     *
     * @param itemId 
     * @return Item deleted
     */
    @DELETE
    @Path("/{itemId}")
    @Operation(summary = "Delete a specific inventory item", description = "" )
    Response inventoryItemIdDelete(@PathParam("itemId") String itemId);

    /**
     * 
     *
     * @param itemId 
     * @return Inventory item details
     * @return Item not found
     */
    @GET
    @Path("/{itemId}")
    @Operation(summary = "Get a specific inventory item", description = "" )
    Response inventoryItemIdGet(@PathParam("itemId") String itemId);

    /**
     * 
     *
     * @param itemId 
     * @param inventoryItem 
     * @return Item updated
     */
    @PUT
    @Path("/{itemId}")
    @Consumes({ "application/json" })
    @Operation(summary = "Update a specific inventory item", description = "" )
    Response inventoryItemIdPut(@PathParam("itemId") String itemId,@Valid @NotNull InventoryItem inventoryItem);

    /**
     * 
     *
     * @param inventoryItem 
     * @return Item created
     */
    @POST
    @Consumes({ "application/json" })
    @Operation(summary = "Create a new inventory item", description = "" )
    Response inventoryPost(@Valid @NotNull InventoryItem inventoryItem);
}
