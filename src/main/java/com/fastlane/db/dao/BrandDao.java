package com.fastlane.db.dao;

import com.fastlane.db.model.inventory.Brand;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class BrandDao extends AbstractDAO<Brand> {

    public BrandDao(SessionFactory factory) {
        super(factory);
    }

    public Optional<Brand> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Brand create(Brand brand) {
        return persist(brand);
    }
}
