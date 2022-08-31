package com.example.productcruddontjpa.interfaceProduct;

import com.example.productcruddontjpa.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepositories {
    public List<Product> queryProduct() throws SQLException, ClassNotFoundException;

    public Product findProduct(int id) throws SQLException,ClassNotFoundException;
    public Product updateProduct(Product prd, int id) throws SQLException,ClassNotFoundException;
    public Product insertProduct(Product pd) throws SQLException,ClassNotFoundException;
    public String deleteProduct(int id) throws SQLException, ClassNotFoundException;
}
