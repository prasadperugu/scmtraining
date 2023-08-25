package com.prasad.scm.springapplication.kafka.controllers;


import java.io.FileNotFoundException;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;



@RestControllerAdvice
public class AppExceptionController {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException e) {
        return new ResponseEntity<>("NullPointerException occurred: " + e.getMessage(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(FileNotFoundException e) {
        return new ResponseEntity<>("FileNotFoundException occurred: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> handleUsernameNotFoundException(UsernameNotFoundException e) {
        return new ResponseEntity<>("UsernameNotFoundException occurred: " + e.getMessage(), HttpStatus.ACCEPTED);
    }

    // You can add more custom exception handlers here based on your application's needs.

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
