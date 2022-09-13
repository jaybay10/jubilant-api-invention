package com.example.operationfineapplev2.Service;

import com.example.operationfineapplev2.DAO.Product;

import java.util.List;

/*
 * @AUTHOR: JASON BAYFORD
 * @VERSION 1
 * @DATE 25/09/2022
 */
public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(long id);
    Product updateProduct(Product product, long id);
    void deleteProduct(long id);
}
