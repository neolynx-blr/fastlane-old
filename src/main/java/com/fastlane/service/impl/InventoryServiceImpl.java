package com.fastlane.service.impl;

import com.fastlane.api.response.UIProductSummary;
import com.fastlane.cache.CategoryCache;
import com.fastlane.db.dao.ProductDao;
import com.fastlane.db.model.inventory.Category;
import com.fastlane.db.model.inventory.Product;
import com.fastlane.helper.models.ScreenDimension;
import com.fastlane.helper.util.InventoryImageSelector;
import com.fastlane.service.InventoryService;
import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {

    public final ProductDao productDao;
    private final CategoryCache categoryCache;

    public InventoryServiceImpl(ProductDao productDao, CategoryCache categoryCache) {
        this.productDao = productDao;
        this.categoryCache = categoryCache;
    }

    @Override
    public UIProductSummary getProductByBarcodeId(Long barcodeId, ScreenDimension screenDimension) {
        Optional<Product> productOptional = productDao.findByBarcodeId(barcodeId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            String imageUrl = InventoryImageSelector.getImageUrl(screenDimension, product.getImageURLJSON());
            List<Category> categories = categoryCache.getCategoryIds(product.getCategoryIds());
            List<String> categoryTags = new ArrayList<>();
            for (Category category : categories) {
                categoryTags.add(category.getName());
            }
            UIProductSummary uiProductSummary = TOConverter.getUIProductSummaryByProductEntity(product);
            uiProductSummary.setImageUrl(imageUrl);
            uiProductSummary.setCategories(categoryTags);
            return uiProductSummary;
        } else {
            //TODO: Handle it in better way
            return null;
        }
    }

    @Override
    public UIProductSummary getProductByProductId(Long productId, ScreenDimension screenDimension) {
        Optional<Product> productOptional = productDao.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            String imageUrl = InventoryImageSelector.getImageUrl(screenDimension, product.getImageURLJSON());
            List<Category> categories = categoryCache.getCategoryIds(product.getCategoryIds());
            List<String> categoryTags = new ArrayList<>();
            for (Category category : categories) {
                categoryTags.add(category.getName());
            }
            UIProductSummary uiProductSummary = TOConverter.getUIProductSummaryByProductEntity(product);
            uiProductSummary.setImageUrl(imageUrl);
            uiProductSummary.setCategories(categoryTags);
            return uiProductSummary;
        } else {
            //TODO: Handle it in better way
            return null;
        }
    }

    public static class TOConverter{
        public static UIProductSummary getUIProductSummaryByProductEntity(Product product){
            UIProductSummary uiProductSummary = UIProductSummary.builder().setProductId(product.getId())
                    .setBardCodeId(product.getBarCodeId()).setDesc(product.getDescription())
                    .setName(product.getName()).build();

            return uiProductSummary;
        }
    }

}

