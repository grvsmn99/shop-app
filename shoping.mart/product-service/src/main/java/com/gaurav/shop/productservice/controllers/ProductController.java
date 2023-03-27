package com.gaurav.shop.productservice.controllers;

import com.gaurav.shop.productservice.entities.Product;
import com.gaurav.shop.productservice.model.ProductRequest;
import com.gaurav.shop.productservice.model.ProductResponse;
import com.gaurav.shop.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest){
        return new ResponseEntity<>(productService.createProduct(productRequest), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable String id){
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }
}
