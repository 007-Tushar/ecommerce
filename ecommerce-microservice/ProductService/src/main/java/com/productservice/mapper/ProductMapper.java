package com.productservice.mapper;

import com.productservice.dto.ProductDto;
import com.productservice.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductDto productDto){
        return new Product(
                productDto.getProductName(),
                productDto.getPrice(),
                productDto.getStock()
        );
    }

    public ProductDto toDto(Product product){
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getPrice(),
                product.getStock()
        );
    }
}
