package com.springboot.productservice.service;

import com.springboot.productservice.data.Product;
import com.springboot.productservice.repo.ProductRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public Product save(Product book) {
        return productRepository.save(book);
    }

    public Product findByName(String name) throws BadRequestException {
        var product =  productRepository.findByName(name);
        if(Objects.isNull(product))
            throw new BadRequestException("Invalid name");

        return product;
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }


}
