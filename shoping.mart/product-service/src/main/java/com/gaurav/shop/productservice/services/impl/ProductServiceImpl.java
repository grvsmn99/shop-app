package com.gaurav.shop.productservice.services.impl;

import com.gaurav.shop.productservice.entities.Product;
import com.gaurav.shop.productservice.exceptions.ProductNotFoundException;
import com.gaurav.shop.productservice.model.ProductRequest;
import com.gaurav.shop.productservice.model.ProductResponse;
import com.gaurav.shop.productservice.repositories.ProductRepository;
import com.gaurav.shop.productservice.services.ProductService;
import com.gaurav.shop.productservice.utils.ProductUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.id.UUIDGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        String uuid = UUID.randomUUID().toString();
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .id(uuid)
                .build();

        Product response =  repository.save(product);
        log.info("Product got created and saved with ID:{}",response.getId());
        ProductResponse productResponse = ProductResponse.builder()
                .id(response.getId())
                .name(response.getName())
                .description(response.getDescription())
                .price(response.getPrice()).build();
        return productResponse;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = repository.findAll();
        return products.stream()
                .map(ProductUtil::mapToProductResponse).collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProduct(String id) throws ProductNotFoundException{
        Product product = repository.findById(id).orElseThrow(ProductNotFoundException::new);
        return ProductUtil.mapToProductResponse(product);
    }

}
