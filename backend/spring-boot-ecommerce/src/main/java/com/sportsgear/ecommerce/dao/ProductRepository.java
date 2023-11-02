package com.sportsgear.ecommerce.dao;

/*
    Created by tylermckenney on 11/2/23.
*/

import com.sportsgear.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
