package com.gaurav.shop.productservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="product_")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
