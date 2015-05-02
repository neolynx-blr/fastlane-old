package com.fastlane.service;


import com.fastlane.db.model.inventory.Product;

public interface InventoryService {

    public Product getProductByBarcodeId(Long barcodeId);
    
}
