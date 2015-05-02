package com.fastlane.db.dao;

import com.fastlane.db.model.inventory.Product;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class ProductDao extends AbstractDAO<Product> {

    public ProductDao(SessionFactory factory) {
        super(factory);
    }

    public Optional<Product> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Product create(Product product) {
        return persist(product);
    }

    public Optional<Product> findByBarcodeId(Long barCodeId){
        Criteria cr = currentSession().createCriteria(Product.class);
        cr.add(Restrictions.eq("barcode", barCodeId));
        Product product = (Product)cr.uniqueResult();
        return Optional.fromNullable(product);
    }
}
