package com.gaurav.shop.productservice.utils;

import com.gaurav.shop.productservice.entities.Product;
import com.gaurav.shop.productservice.model.ProductResponse;

public class ProductUtil {

    public static ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }
}
