package com.gaurav.shop.productservice.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(){
        super("Product No Found");
    }

    public ProductNotFoundException(String message){
        super(message);
    }
}
