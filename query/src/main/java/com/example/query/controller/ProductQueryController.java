package com.example.query.controller;

import com.example.query.model.Product;
import com.example.query.service.ProductQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 假设查询不需要路径参数
@RestController
@RequestMapping("/api/queries")
public class ProductQueryController {

    private final ProductQueryService productQueryService;

    public ProductQueryController(ProductQueryService productQueryService) {
        this.productQueryService = productQueryService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productQueryService.getAllProducts();
    }
}
