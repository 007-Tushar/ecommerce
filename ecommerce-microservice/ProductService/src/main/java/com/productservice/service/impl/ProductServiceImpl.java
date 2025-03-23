package com.productservice.service.impl;


import com.productservice.dto.ProductDto;
import com.productservice.entity.Product;
import com.productservice.mapper.ProductMapper;
import com.productservice.repository.ProductRepository;
import com.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("No Product found with ID: " + productId));
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDto> getProductAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedproduct = productRepository.save(product);
        return productMapper.toDto(savedproduct);
    }
}
