package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
        final String name = "상품명";
        final BigDecimal price = BigDecimal.valueOf(10000);
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;


        final AddProductReqeust request = new AddProductReqeust(name, price, discountPolicy);
        productService.addProduct(request);
    }
    
    private class ProductService {

        private final ProductPort productPort;

        private ProductService(ProductPort productPort) {
            this.productPort = productPort;
        }

        public void addProduct(AddProductReqeust request) {
            Product product = new Product(request.name(), request.price(), request.discountPolicy());

            productPort.save(product);
        }
    }

    private record AddProductReqeust(String name, BigDecimal price, DiscountPolicy discountPolicy) {
    }

    private enum DiscountPolicy {
        NONE
    }

    private class Product {
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

    private interface ProductPort {
        void save(final Product product);
    }

    private class ProductAdapter implements  ProductPort {

        private final ProductRepository productRepository;

        private ProductAdapter(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public void save(Product product) {
            productRepository.save(product);
        }
    }

    private class ProductRepository {
        private Long sequence = 0L;
        private Map<Long, Product> persistence = new HashMap<>();

        public void save(Product product) {
            product.assignId(++sequence);
            persistence.put(product.getId(), product);
        }
    }
}
