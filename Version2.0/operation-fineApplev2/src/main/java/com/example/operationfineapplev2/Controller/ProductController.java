package com.example.operationfineapplev2.Controller;

import com.example.operationfineapplev2.DAO.Product;
import com.example.operationfineapplev2.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
@AUTHOR JASON BAYFORD
@VERSION 1
@DATE 25/08/2022
-------------------- -------------------- -------------------- -------------------- -------------------- --------------------
    THIS CLASS WILL BE RESPONSIBLE FOR OUR API CALLS:
    - GET
    - POST
    - PUT
    - DELETE

    @REST CONTROLLER -> IS USED FOR MAKING RESTFUL WEB SERVICES, THIS ANNOTATION HANDLES REQUESTS MADE BY THE CLIENT. IT IS A CONVENIENT ANNOTATION
    THAT COMBINES @CONTROLLER AND @RESPONSE BODY, WHICH ELIMINATES THE NEED TO ANNOTATE EVERY REQUEST HANDLING METHOD OF THE CONTROLLER CLASS WITH
    THE RESPONSE BODY ANNOTATION
    @REQUEST MAPPING -> IS BASICALLY USED TO MAP WEB REQUESTS ONTO A SPECIFIC HANDLER CLASS OR METHOD. (EXAMPLE/API/V2.0)
    @AUTOWIRED -> AUTOMATICALLY INJECTS THE PRODUCT SERVICE CLASS. HOWEVER, FOR CONSISTENCY WE ARE USING A CONSTRUCTOR.
*/
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    /*
-------------------- -------------------- -------------------- -------------------- -------------------- --------------------
     WE ARE INJECTING PRODUCT SERVICE INTO OUR CONTROLLER CLASS.
     WE CAN ALSO USE @AUTOWIRED TO REDUCE BOILERPLATE CODE, WHICH IN THIS CASE IS A CONSTRUCTOR THAT WE ARE USING FOR THE
     PRODUCT SERVICE CLASS.
*/

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*
-------------------- -------------------- -------------------- -------------------- -------------------- --------------------
         THIS API WILL BE RESPONSIBLE FOR SAVING PRODUCTS TO MYSQL DATABASE
         THE REQUEST MAPPING -> localhost:8080/api/v1/saveProduct
    */

   @PostMapping("/saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

     /*
-------------------- -------------------- -------------------- -------------------- -------------------- --------------------
           THIS API WILL BE RESPONSIBLE FOR FETCHING ALL THE PRODUCTS FROM MYSQL DATABASE
           THE REQUEST MAPPING -> localhost:8080/api/v1/allProducts
 */
    @GetMapping("/allProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

      /*
-------------------- -------------------- -------------------- -------------------- -------------------- --------------------
           THIS API WILL BE RESPONSIBLE FOR FETCHING A PRODUCT VIA THE PRODUCT ID FROM MYSQL DATABASE
           THIS METHOD WILL ALSO BE HANDLING THE EXCEPTION CLASS THAT HAS BEEN CREATED TO SEND A MESSAGE TO THE CLIENT,
           NOTIFYING THE CLIENT THAT PRODUCT IS NOT LISTED IN MYSQL DATABASE.
           A RESPONSE ENTITY METHOD IS USED TO SEND A HTTP REQUEST
           THE REQUEST MAPPING -> localhost:8080/api/v1/product{id}
 */
    @GetMapping("/product{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId){
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

 /*
-------------------- -------------------- -------------------- -------------------- -------------------- --------------------
           THIS API WILL BE RESPONSIBLE FOR UPDATING PRODUCTS TO MYSQL DATABASE
           THIS API WILL FIRST FETCH THE DATA FROM THE MYSQL DATABASE IF PRODUCT DOES NOT EXIST A MESSAGE WILL BE SENT BACK TO THE CLIENT.
           ONCE DATA IS FETCHED THE USER CAN THEN UPDATE THE PRODUCT NAME, DESCRIPTION AND PRICE.
           A RESPONSE ENTITY METHOD IS USED TO SEND A HTTP REQUEST
           THE REQUEST MAPPING -> localhost:8080/api/v1/product{id}
   */

    @PutMapping("/product{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long productId, @RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product, productId), HttpStatus.OK);
    }

            /*
-------------------- -------------------- -------------------- -------------------- -------------------- --------------------
           THIS API WILL BE RESPONSIBLE FOR DELETING PRODUCTS TO MYSQL DATABASE
           THIS API WILL FIRST FETCH THE DATA FROM THE MYSQL DATABASE IF PRODUCT DOES NOT EXIST A MESSAGE WILL BE SENT BACK TO THE CLIENT.
           USED A MAP FUNCTION TO SEND THE RESPONSE BACK TO THE CLIENT
           A RESPONSE ENTITY METHOD IS USED TO SEND A HTTP REQUEST
           THE REQUEST MAPPING -> localhost:8080/api/v1/product{id}
        */

    @DeleteMapping("/product{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        /*THIS WILL DELETE THE PRODUCT FROM THE DATABASE*/
        productService.deleteProduct(id);

        /*RETURNING A SUCCESSFUL MESSAGE*/
        return new ResponseEntity<>("Product deleted successfully...!!!", HttpStatus.OK);
    }
}
