package com.example.productcruddontjpa.service;


import com.example.productcruddontjpa.entity.Product;
import com.example.productcruddontjpa.interfaceProduct.ProductRepositories;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class productDAO implements ProductRepositories {
    public static List<Product> products = new ArrayList<Product>();

    public static Connection getConnection()
            throws ClassNotFoundException, SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/product2";
        String USER_NAME = "root";
        String PASSWORD = "1234";
        Connection conn = DriverManager.getConnection(DB_URL, USER_NAME,
                PASSWORD);
        System.out.println("ket noi ok");
        return conn;

    }

    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }

    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
        }
    }

    public List<Product> queryProduct() throws SQLException, ClassNotFoundException {
        String sql = "select * from product_tbl";
        Connection conn = getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            Product pd = new Product(rs.getInt("id"), rs.getString("Name"), rs.getInt("Quantity"), rs.getDouble("Price"));
            list.add(pd);

        }
        products = list;
        return list;
    }

    public Product findProduct(int id) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        String sql = "select * from product_tbl where id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            Product pd = new Product(id, rs.getString("Name"), rs.getInt("Quantity"), rs.getDouble("Price"));
            return pd;
        }
        return null;
    }

    public Product updateProduct(Product prd, int id) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
//        StringBuilder sql = new StringBuilder();
//        sql.append("update product_tbl set name=?, quantity= ?, price=?");
//        sql.append(" where id = " + id);
        String sql="update product_tbl set name=?, quantity= ?, price=? where id="+id;
        queryProduct();

        for (Product p : products) {
            if (id == p.getId()) {
                PreparedStatement pstm = conn.prepareStatement(sql.toString());
                System.out.println(pstm);
                pstm.setString(1, prd.getName());
                pstm.setInt(2, prd.getQuantity());
                pstm.setDouble(3, prd.getPrice());
                pstm.executeUpdate();
                System.out.println("update successful");
                return prd;
            }
        }

        return null;

    }

    public Product insertProduct(Product pd) throws SQLException, ClassNotFoundException {

        Connection conn = getConnection();
        String sql = "insert into product_tbl set name=?, quantity=?, price=?";
        // tạo đối tượng pstm để thực thi câu lệnh sql
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, pd.getName());
        pstm.setInt(2, pd.getQuantity());
        pstm.setDouble(3, pd.getPrice());
        pstm.executeUpdate();
        return pd;
    }

    public String deleteProduct(int id) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("delete from product_tbl");
        sql.append(" where id = " + id);
        PreparedStatement pstm = conn.prepareStatement(String.valueOf(sql));
        pstm.execute();
        return "delete from product";
    }
//    public static void PrintListProduct(Connection con) throws SQLException,ClassNotFoundException {
//
//        List list=queryProduct(con);
//        for(int i=0;i<list.size();i++) {
//            Product p=(Product)list.get(i);
//            p.printlnInfor();
//        }
    //   }
}