package com.example.e_commerce.product.service;

import com.example.e_commerce.product.domain.Product;
import com.example.e_commerce.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getProduct(long productId) throws Exception {
        return productRepository.findById(productId).orElseThrow(Exception::new);
    }
}
