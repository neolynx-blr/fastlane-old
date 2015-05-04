package com.fastlane.db.dao;

import com.fastlane.db.model.inventory.Category;
import com.fastlane.db.model.inventory.Product;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by nishantgupta on 4/5/15.
 */
public class CategoryDao extends AbstractDAO<Category> {

    public CategoryDao(SessionFactory factory) {
        super(factory);
    }

    public List<Category> findAll(){
        Criteria cr = currentSession().createCriteria(Category.class);
        return super.list(cr);
    }
}
