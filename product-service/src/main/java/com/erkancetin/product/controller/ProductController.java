package com.erkancetin.product.controller;

import com.erkancetin.product.model.Product;
import com.erkancetin.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.add(product));
    }


    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.getAll());
    }
}
