package com.example.store.carts;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartProductDto {
    private Integer id;
    private String name;
    private BigDecimal price;
}
