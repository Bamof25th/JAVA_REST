package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entites.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(products);
    }

    @GetMapping("/{pid}")
    public ResponseEntity<?> getMethodName(@PathVariable Long pid) {
        System.out.println("pid : " + pid);
        Product product = productService.getProductById(pid);
        return product == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<?> addNewProduct(@RequestBody Product product) {

        try {
            return ResponseEntity.ok(productService.addNewProduct(product));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

}
