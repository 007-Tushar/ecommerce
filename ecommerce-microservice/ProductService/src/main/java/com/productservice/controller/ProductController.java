package com.productservice.controller;

import com.productservice.dto.OrderItemDto;
import com.productservice.dto.OrderItemRequest;
import com.productservice.dto.ProductDto;
import com.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //
    // Get Product by Product ID
    //

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId){
        try {
            ProductDto productDto = productService.getProductById(productId);
            return ResponseEntity.ok(productDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //
    // Get All Products
    //

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProductAll(){
        return ResponseEntity.ok(productService.getProductAll());
    }


    //
    // Create a Product
    //

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto createdProduct = productService.createProduct(productDto);
        return ResponseEntity.ok(createdProduct);
    }

    //
    // Get stock and product price
    //

    @GetMapping("/orderItem")
    public ResponseEntity<OrderItemDto> orderItemDto(@RequestBody OrderItemRequest orderItemRequest){
        try{
            return ResponseEntity.ok(productService.orderItemData(orderItemRequest.getProductId(), orderItemRequest.getQuantity()));
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
