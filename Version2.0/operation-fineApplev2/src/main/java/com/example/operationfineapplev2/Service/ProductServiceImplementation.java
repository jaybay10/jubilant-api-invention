package com.example.operationfineapplev2.Service;

import com.example.operationfineapplev2.DAO.Product;
import com.example.operationfineapplev2.Exception.ResourceNotFoundException;
import com.example.operationfineapplev2.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


/*
* @AUTHOR: JASON BAYFORD
* @VERSION 1
* @DATE 25/09/2022
*/
@Service
public class ProductServiceImplementation implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        } else {
            throw new ResourceNotFoundException("Product not listed " + id);
        }

    }

    @Override
    public Product updateProduct(Product product, long id) {
        /* CHECKING TO SEE IF PRODUCT EXIST WITHIN THE DATABASE */
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This product is not listed in the database"));

        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductDescription(product.getProductDescription());
        existingProduct.setProductPrice(product.getProductPrice());

        /*SAVING THE EXISTING PRODUCT TO THE DATABASE*/
        productRepository.save(existingProduct);
        return existingProduct;
    }

    @Override
    public void deleteProduct(long id) {
        /* CHECKING TO SEE IF PRODUCT EXIST WITHIN THE DATABASE */
        productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This product is not listed"));
        productRepository.deleteById(id);
    }
}
