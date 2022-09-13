package com.example.operationfineapplev2.Repository;

import com.example.operationfineapplev2.DAO.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
 * @AUTHOR: JASON BAYFORD
 * @VERSION 1
 * @DATE 25/09/2022
-------------------- -------------------- -------------------- -------------------- -------------------- --------------------
    THIS CLASS IS RESPONSIBLE FOR EXPOSING DATABASE METHODS, IT PROVIDES OUT OF THE BOX IMPLEMENTATION FOR ALL DATABASES METHODS
    SO ONE DOES NOT NEED TO WRITE BINARY CODE THAT IS REQUIRED TO DEVELOP:
    -SAVE
    -FIND
    -DELETE
    -DELETE BY ID

   @REPOSITORY -> IS USED TO INDICATE THAT THE CLASS PROVIDES A MECHANISM FOR
    - STORAGE
    - RETRIEVAL,
    - SEARCH
    - UPDATE
    - DELETE OPERATION ON OBJECTS
*/

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
