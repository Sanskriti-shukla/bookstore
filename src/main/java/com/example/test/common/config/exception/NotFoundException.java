package com.example.test.common.config.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String  message){
        super(message);
    }
}
