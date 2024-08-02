package com.firstApp.exception;

public class ValidationRequestException  extends RuntimeException{
    public ValidationRequestException(String message){
        super(message);
    }
}
