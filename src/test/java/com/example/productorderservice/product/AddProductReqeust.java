package com.example.productorderservice.product;

import java.math.BigDecimal;

record AddProductReqeust(String name, BigDecimal price, DiscountPolicy discountPolicy) {
}
