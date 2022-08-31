package com.example.qlbh_jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_tbl")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name",columnDefinition="varchar(255)")
    private String name;

    @Column (name = "quantity",columnDefinition = "smallint(11)")
    private int quantity;

    @Column (name = "price" , columnDefinition = "decimal(10,1)")
    private double price;
}