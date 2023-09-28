package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository  = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

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
