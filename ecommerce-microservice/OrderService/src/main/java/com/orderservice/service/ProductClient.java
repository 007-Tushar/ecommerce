package com.orderservice.service;

import com.orderservice.dto.OrderItemDto;
import com.orderservice.dto.OrderItemRequest;
import com.orderservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "SERVICE-PRODUCT")
public interface ProductClient {

    @PostMapping("/product/orderItem")
    ResponseEntity<OrderItemDto> createOrderItem(@RequestBody OrderItemRequest orderItemRequest);

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId);
}