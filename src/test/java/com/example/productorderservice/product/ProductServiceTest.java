package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void 상품등록() {
        final AddProductReqeust request = 상품등록요청_생성();

        productService.addProduct(request);
    }

    private static AddProductReqeust 상품등록요청_생성() {
        final String name = "상품명";
        final BigDecimal price = BigDecimal.valueOf(10000);
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        return new AddProductReqeust(name, price, discountPolicy);
    }

}
