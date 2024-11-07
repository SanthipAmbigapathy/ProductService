package com.springboot.productservice.repo;

import com.springboot.productservice.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

    Product findByName(String name);
}

