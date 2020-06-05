package com.shoppingmall.fancycart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicatedTagOfUserException extends RuntimeException {
    public DuplicatedTagOfUserException(String message) {
        super(message);
    }
}