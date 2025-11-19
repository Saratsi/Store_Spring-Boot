package com.example.store.products;

import lombok.Data;


import java.math.BigDecimal;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer categoryId;
}
