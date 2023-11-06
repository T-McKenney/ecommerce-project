package com.onlinestore.ecommerce.service;

/*
    Created by tylermckenney on 11/5/23.
*/

import com.onlinestore.ecommerce.dto.Purchase;
import com.onlinestore.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
