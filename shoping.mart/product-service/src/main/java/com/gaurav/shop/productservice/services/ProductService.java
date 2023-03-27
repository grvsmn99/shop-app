package com.gaurav.shop.productservice.services;

import com.gaurav.shop.productservice.entities.Product;
import com.gaurav.shop.productservice.exceptions.ProductNotFoundException;
import com.gaurav.shop.productservice.model.ProductRequest;
import com.gaurav.shop.productservice.model.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

    ProductResponse getProduct(String id) throws ProductNotFoundException;
}
