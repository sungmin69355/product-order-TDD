package com.example.productorderservice.product;

import java.math.BigDecimal;
public class Product {
    private final String name;
    private final BigDecimal price;
    private final DiscountPolicy discountPolicy;
    private Long id;

    public Product(String name, BigDecimal price, DiscountPolicy discountPolicy) {
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void assignId(Long id) {
        this.id = id;

    }

    public Long getId() {
        return id;
    }

}
