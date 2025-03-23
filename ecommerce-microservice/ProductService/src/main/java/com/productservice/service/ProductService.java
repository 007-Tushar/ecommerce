package com.productservice.service;

import com.productservice.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProductById(Long productId);

    List<ProductDto> getProductAll();

    ProductDto createProduct(ProductDto productDto);

}
