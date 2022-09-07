package com.example.qlbh_jpa.controller;

import com.example.qlbh_jpa.entity.Product;
import com.example.qlbh_jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product) {
        service.saveProduct(product);
        return "succesfuly";
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    // Xóa tất cả sản phẩm
    @DeleteMapping("/delete")
    public String deleteAllProduct() {
        return service.deleteAllProduct();
    }
}

/*

        [{
        "name": "Product1",
        "quantity": 1,
        "price": 1000.0
        },

        {
        "name": "Product2",
        "quantity": 2,
        "price": 2000.0
        },

        {
        "name": "Product3",
        "quantity": 3,
        "price": 3000.0
        }
        ]

 */