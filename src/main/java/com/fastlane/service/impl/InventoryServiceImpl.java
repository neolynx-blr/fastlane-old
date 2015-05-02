package com.fastlane.service.impl;

import com.fastlane.db.dao.BrandDao;
import com.fastlane.db.dao.ProductDao;
import com.fastlane.db.model.inventory.Product;
import com.fastlane.service.InventoryService;
import com.google.common.base.Optional;

public class InventoryServiceImpl implements InventoryService{

    public final ProductDao productDao;

    public InventoryServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product getProductByBarcodeId(Long barcodeId){
        Optional<Product> productOptional = productDao.findByBarcodeId(barcodeId);
        if(productOptional.isPresent()){
            return productOptional.get();
        }else{
            return productOptional.orNull();
        }
    }
}
