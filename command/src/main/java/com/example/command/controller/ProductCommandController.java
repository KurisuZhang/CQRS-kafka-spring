package com.example.command.controller;

import com.example.command.model.Product;
import com.example.command.model.ProductEvent;
import com.example.command.service.ProductCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/commands")
public class ProductCommandController {

    @Autowired
    private ProductCommandService productCommandService;


    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        return productCommandService.consumeProductEvent(new ProductEvent("ADD", product));
    }
}
