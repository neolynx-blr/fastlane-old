package com.fastlane.application;

import com.fastlane.cache.CategoryCache;
import com.fastlane.db.dao.CategoryDao;
import com.fastlane.db.model.inventory.Brand;
import com.fastlane.db.model.inventory.Category;
import com.fastlane.db.model.inventory.Product;
import com.fastlane.db.dao.BrandDao;
import com.fastlane.db.dao.ProductDao;
import com.fastlane.resource.InventoryResource;
import com.fastlane.service.InventoryService;
import com.fastlane.service.impl.InventoryServiceImpl;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by nishantgupta on 3/4/15.
 */
public class FastLaneApplication extends Application<FastLaneConfig> {
    @Override
    public void run(FastLaneConfig fastLaneConfig, Environment environment) throws Exception {
        final BrandDao brandDao = new BrandDao(hibernateBundle.getSessionFactory());
        final ProductDao productDao = new ProductDao(hibernateBundle.getSessionFactory());
        final CategoryDao categoryDao = new CategoryDao(hibernateBundle.getSessionFactory());

        final CategoryCache categoryCache = new CategoryCache(categoryDao);
        categoryCache.init();

        final InventoryService inventoryService = new InventoryServiceImpl(productDao, categoryCache);
        environment.jersey().register(new InventoryResource(inventoryService));

    }

    private final HibernateBundle<FastLaneConfig> hibernateBundle =
            new HibernateBundle<FastLaneConfig>(Product.class, Brand.class, Category.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(FastLaneConfig configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public String getName() {
        return "fastlane";
    }

    @Override
    public void initialize(Bootstrap<FastLaneConfig> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );
        bootstrap.addBundle(hibernateBundle);
    }

    public static void main(String[] args) throws Exception {
        new FastLaneApplication().run(args);
    }

}
