package com.example.query.service;

import com.example.query.model.Product;
import com.example.query.model.ProductEvent;
import com.example.query.repository.ProductRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQueryService {

    private final ProductRepository productRepository;

    public ProductQueryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @KafkaListener(topics = "product-events", groupId = "query-group")
    public void consumeProductEvent(ProductEvent event) {
        switch (event.getEventType()) {
            case "ADD":
            case "UPDATE":
                productRepository.save(event.getProduct());
                break;
            case "DELETE":
                productRepository.deleteById(event.getProduct().getId());
                break;
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
