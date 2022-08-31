package com.example.productcruddontjpa.controller;


import com.example.productcruddontjpa.entity.Product;
import com.example.productcruddontjpa.service.productDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private productDAO service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) throws SQLException, ClassNotFoundException {
        return service.insertProduct(product);
    }


    @GetMapping("/products")
    public List<Product> getlistProducts() throws SQLException, ClassNotFoundException {
        return service.queryProduct();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return service.findProduct(id);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) throws SQLException, ClassNotFoundException {
        return service.updateProduct(product, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return service.deleteProduct(id);
    }
}