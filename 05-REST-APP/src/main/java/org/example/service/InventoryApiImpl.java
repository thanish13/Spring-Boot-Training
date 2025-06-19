package org.example.service;

import jakarta.ws.rs.core.Response;
import org.example.api.InventoryApi;
import org.example.model.InventoryItem;

public class InventoryApiImpl implements InventoryApi {

    @Override
    public Response inventoryGet() {
        return null;
    }

    @Override
    public Response inventoryItemIdDelete(String itemId) {
        return null;
    }

    @Override
    public Response inventoryItemIdGet(String itemId) {
        return null;
    }

    @Override
    public Response inventoryItemIdPut(String itemId, InventoryItem inventoryItem) {
        return null;
    }

    @Override
    public Response inventoryPost(InventoryItem inventoryItem) {
        return null;
    }
}
