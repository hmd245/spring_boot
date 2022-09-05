package com.example.productcruddontjpa.interfaceProduct;

import com.example.productcruddontjpa.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepositories {
    public Product insertProduct(Product pd) throws SQLException, ClassNotFoundException;

    public List<Product> insertProducts(List<Product> pd) throws SQLException, ClassNotFoundException;

    public List<Product> getProducts() throws SQLException, ClassNotFoundException;

    public Product findProduct(int id) throws SQLException, ClassNotFoundException;

    public Product updateProduct(Product prd, int id) throws SQLException, ClassNotFoundException;

    public String deleteProduct(int id) throws SQLException, ClassNotFoundException;

    public String deleteAllProduct() throws SQLException, ClassNotFoundException;
}
