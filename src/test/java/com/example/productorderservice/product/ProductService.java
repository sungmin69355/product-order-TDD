package com.example.productorderservice.product;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
class ProductService {

    private final ProductPort productPort;

    ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    @Transactional
    public void addProduct(AddProductReqeust request) {
        Product product = new Product(request.name(), request.price(), request.discountPolicy());

        productPort.save(product);
    }
}
