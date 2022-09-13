package com.example.operationfineapplev2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/*
 * @AUTHOR: JASON BAYFORD
 * @VERSION 1
 * @DATE 25/09/2022
-------------------- -------------------- -------------------- -------------------- -------------------- --------------------
    THIS CLASS WILL BE RESPONSIBLE FOR RESOURCES THAT DO NOT EXIST WITHIN MYSQL DATABASE
    WILL RETURN A NOT FOUND MESSAGE TO THE CLIENT IF RESOURCE CAN NOT BE FOUND IN THE DATABASE
*/
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);

    }
}
