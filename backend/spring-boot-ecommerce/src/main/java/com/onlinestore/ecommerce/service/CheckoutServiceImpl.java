package com.onlinestore.ecommerce.service;

/*
    Created by tylermckenney on 11/5/23.
*/

import com.onlinestore.ecommerce.dao.CustomerRepository;
import com.onlinestore.ecommerce.dto.Purchase;
import com.onlinestore.ecommerce.dto.PurchaseResponse;
import com.onlinestore.ecommerce.entity.Customer;
import com.onlinestore.ecommerce.entity.Order;
import com.onlinestore.ecommerce.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order information from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate the order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(order::add);

        // populate order with billingAddress and shippingAddress
        order.setShippingAddress(purchase.getShippingAddress());
        order.setBillingAddress(purchase.getBillingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the DB
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number
        return UUID.randomUUID().toString();
    }
}
