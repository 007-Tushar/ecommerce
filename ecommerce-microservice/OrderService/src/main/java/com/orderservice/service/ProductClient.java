package com.orderservice.service;


import com.orderservice.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "SERVICE-PRODUCT")
public interface ProductClient {

    @GetMapping("/orders/{orderId}/products") // Define the correct endpoint URL for fetching products for an order
    List<Product> getProductsOfOrder(@PathVariable("orderId") Long orderId); // Use @PathVariable with parameter name
}