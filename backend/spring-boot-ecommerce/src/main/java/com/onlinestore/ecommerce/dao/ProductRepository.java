package com.onlinestore.ecommerce.dao;

/*
    Created by tylermckenney on 11/2/23.
*/

import com.onlinestore.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200") // Accept calls from web browser scripts for this origin
public interface ProductRepository extends JpaRepository<Product, Long> {
}
