package com.example.productorderservice.product;

import org.springframework.stereotype.Component;

@Component
interface ProductPort {
    void save(final Product product);
}
