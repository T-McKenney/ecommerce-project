package com.onlinestore.ecommerce.dao;

/*
    Created by tylermckenney on 11/2/23.
*/

import com.onlinestore.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Add query method - performs SQL query: SELECT * FROM product WHERE category_id=?
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    // Query method - performs SQL: SELECT * FROM Product p WHERE p.name LIKE CONCAT('%', :name, '%')
    // Used to find any p.name containing the search keywords input on the webpage
    Page<Product> findByNameContaining(@Param("name") String name, Pageable page);
}
