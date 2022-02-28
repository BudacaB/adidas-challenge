package com.adidas.publicservice.config;

import com.adidas.publicservice.exceptions.InvalidEmailException;
import com.adidas.publicservice.exceptions.SubscriptionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({SubscriptionNotFoundException.class})
    public ResponseEntity<?> handleSubscriptionNotFoundException(SubscriptionNotFoundException subscriptionNotFoundException) {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidEmailException.class})
    public ResponseEntity<?> handleInvalidEmailException(InvalidEmailException invalidEmailException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid email");
    }
}
