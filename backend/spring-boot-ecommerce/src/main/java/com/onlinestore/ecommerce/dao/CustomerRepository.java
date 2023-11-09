package com.onlinestore.ecommerce.dao;

/*
    Created by tylermckenney on 11/5/23.
*/

import com.onlinestore.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String theEmail); // performs: SELECT * FROM Customer where customer.email = thEmail
}
