package com.orderservice.controller;

import com.orderservice.dto.OrderDto;
import com.orderservice.dto.OrderRequest;
import com.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.createOrder(orderRequest));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<OrderDto>> getAllOrdersOfProduct(@PathVariable Long productId){
        return ResponseEntity.ok(orderService.getAllOrderByProductId(productId));
    }

}
