package com.onlinestore.ecommerce.controller;

/*
    Created by tylermckenney on 11/5/23.
*/

import com.onlinestore.ecommerce.dto.Purchase;
import com.onlinestore.ecommerce.dto.PurchaseResponse;
import com.onlinestore.ecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}
