package com.springboot.productservice.controller;

import com.springboot.productservice.data.Product;
import com.springboot.productservice.service.ProductService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Product findByName(@PathVariable String name) throws BadRequestException {
        return productService.findByName(name);
    }

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.save(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        productService.deleteById(id);
    }
}
