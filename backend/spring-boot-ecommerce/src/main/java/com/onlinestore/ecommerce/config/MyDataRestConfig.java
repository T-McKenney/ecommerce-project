package com.onlinestore.ecommerce.config;

/*
    Created by tylermckenney on 11/2/23.
*/

import com.onlinestore.ecommerce.entity.Country;
import com.onlinestore.ecommerce.entity.Product;
import com.onlinestore.ecommerce.entity.ProductCategory;
import com.onlinestore.ecommerce.entity.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private final EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // Disable HTTP methods for Product: Put, POST, and DELETE
        disableHttpMethods(Product.class, config, theUnsupportedActions);

        // Disable HTTP methods for ProductCategory: Put, POST, and DELETE
        disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);

        // Disable HTTP methods for Country: Put, POST, and DELETE
        disableHttpMethods(Country.class, config, theUnsupportedActions);

        // Disable HTTP methods for State: Put, POST, and DELETE
        disableHttpMethods(State.class, config, theUnsupportedActions);

        // Call an internal helper method to expose the ids
        exposeIds(config);
    }

    private static void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)));
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        // expose entity ids

        // - get a list of all entity classes from the entity manager
        Set<jakarta.persistence.metamodel.EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // - create an array list of the entity types
        List<Class> entityClasses = new ArrayList<>();

        // - get the entity types for the entities
        for (EntityType<?> tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // - expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
