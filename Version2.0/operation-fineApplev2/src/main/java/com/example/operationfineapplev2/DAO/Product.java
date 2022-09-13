package com.example.operationfineapplev2.DAO;


import lombok.Data;
import javax.persistence.*;

/*
 * @AUTHOR: JASON BAYFORD
 * @VERSION 1
 * @DATE 25/09/2022
-------------------- -------------------- -------------------- -------------------- -------------------- --------------------
                ---DAO - DATA ACCESS OBJECT---
    THIS CLASS IS RESPONSIBLE FOR ACCESSING THE NECESSARY DATA FROM AND TO MYSQL DATABASE.

    LOMBOK -> IS AN OPTION TO USE TO REMOVE BOILERPLATE CODE.

          ---JPA ANNOTATION -> JAVA PERSISTENCE ANNOTATION---
    //TODO: ASK YUSUF AND DIYA FOR A SHORT DESCRIPTION
    ENTITY -> {YUSUF OR DIYA CAN PROVIDE A SHORT DESCRIPTION HERE}
    TABLE -> {YUSUF OR DIYA CAN PROVIDE A SHORT DESCRIPTION HERE}
    DATABASE TABLE NAME IS PRODUCTS.

    @DATA -> IS A LOMBOK ANNOTATION THAT ALLOWS US TO NOT GENERATE GETTERS AND SETTERS
    @COLUMN -> IS AN ANNOTATION THAT WILL AUTOMATICALLY CREATE A TABLE HEADER NAME WITHIN THE DATABASE PROVIDE BY THE NAME
    GIVEN WITHIN THE PARENTHESIS. IT ENABLES ONE TO CUSTOMIZE THE MAPPING BETWEEN THE ENTITY AND THE DATABASE COLUMN.
*/

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long productId;
    @Column(name = "productName", nullable = false)
    private String productName;
    @Column(name = "productDescription")
    private String productDescription;
    @Column(name = "productPrice")
    private double productPrice;
}
