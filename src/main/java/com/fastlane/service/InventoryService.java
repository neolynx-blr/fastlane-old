package com.fastlane.service;


import com.fastlane.api.response.UIProductSummary;
import com.fastlane.helper.models.ScreenDimension;

public interface InventoryService {

    public UIProductSummary getProductByBarcodeId(Long barcodeId, ScreenDimension screenDimension);

    public UIProductSummary getProductByProductId(Long productId, ScreenDimension screenDimension);

    
}
