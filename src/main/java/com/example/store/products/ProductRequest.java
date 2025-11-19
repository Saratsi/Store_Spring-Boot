package com.example.store.products;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private String name;
    private BigDecimal price;
    private String description;
    private Integer categoryId;
}
