package com.fastlane.resource;

import com.codahale.metrics.annotation.Timed;
import com.fastlane.api.response.ResponseData;
import com.fastlane.db.model.inventory.Product;
import com.fastlane.service.InventoryService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/fastlane/api")
@Produces(MediaType.APPLICATION_JSON)
public class InventoryResource {

    private InventoryService inventoryService;

    public InventoryResource(final InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GET
    @Timed
    @Path("/barcode/get")
    public ResponseData get(@QueryParam("barcodeId") Long barCodeId) {
        Product product = inventoryService.getProductByBarcodeId(barCodeId);
        return ResponseData.builder().setSuccessMsg("Product for this barcode returned successfully").setData(product).build();
    }
}
