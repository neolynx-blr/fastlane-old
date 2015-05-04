package com.fastlane.cache;

import com.fastlane.db.dao.CategoryDao;
import com.fastlane.db.model.inventory.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nishantgupta on 4/5/15.
 */
public class CategoryCache {

    private final CategoryDao categoryDao;

    public CategoryCache(final CategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }

    private static Map<Long, Category> categoryCacheById = new HashMap<>();

    public void init(){
        List<Category> categoryList = this.categoryDao.findAll();
        for(Category category: categoryList ){
            categoryCacheById.put(category.getId(), category);
        }
    }

    public Category getById(Long categoryId){
        return categoryCacheById.get(categoryId);
    }

    public List<Category> getCategoryIds(List<Long> categoryIds){
        List<Category> categories = new ArrayList<>();
        for(Long categoryId: categoryIds){
            Category category = categoryCacheById.get(categoryId);
            if(category != null) {
                categories.add(category);
            }
        }
        return categories;
    }
}

