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
    public ResponseEntity<?> handleNullPointerException(NullPointerException nullPointerException) {

        return new ResponseEntity<>("NULLPOINTEREXCEPTION EXCEPTION OCCURED",HttpStatus.NO_CONTENT);

    }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<?> handleInternalServerException(InternalServerError internalServerError) {

        return new ResponseEntity<>("INTERNAL SERVER EXCEPTION OCCURED",HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(FileNotFoundException notFoundException) {

        return new ResponseEntity<>("NOTFOUND EXCEPTION OCCURED",HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handleUsernameNotFoundException(UsernameNotFoundException usernameNotFoundException) {

        return new ResponseEntity<>("USERNAMENOTFOUNDEXCEPTION EXCEPTION OCCURED",HttpStatus.ACCEPTED);

    }

    @ExceptionHandler(Unauthorized.class)
    public ResponseEntity<?> handleUnauthorizedExceptions(Unauthorized unauthorized) {

        return new ResponseEntity<>("UNAUTHORIZED EXCEPTION OCCURED",HttpStatus.FORBIDDEN);

    }

}