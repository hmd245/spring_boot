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

    // Thêm danh sách sản phẩm
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) throws SQLException, ClassNotFoundException {
        return service.insertProducts(products);
    }

    @GetMapping("/products")
    public List<Product> getListProducts() throws SQLException, ClassNotFoundException {
        return service.getProducts();
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

    // Xóa tất cả sản phẩm
    @DeleteMapping("/delete")
    public String deleteAllProduct() throws SQLException, ClassNotFoundException {
        return service.deleteAllProduct();
    }
}

/*
[{
        "name": "Product1",
        "quantity": 1,
        "price": 2000.0
        },

        {
        "name": "Product2",
        "quantity": 2,
        "price": 2000.0
        },

        {
        "name": "Product3",
        "quantity": 3,
        "price": 2000.0
        }
        ]

 */