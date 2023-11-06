package com.onlinestore.ecommerce.dto;

/*
    Created by tylermckenney on 11/5/23.
*/

import com.onlinestore.ecommerce.entity.Address;
import com.onlinestore.ecommerce.entity.Customer;
import com.onlinestore.ecommerce.entity.Order;
import com.onlinestore.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
