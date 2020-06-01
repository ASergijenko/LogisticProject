package com.logisticproject.services.validations;

public class ValidationException extends RuntimeException{

    public ValidationException(String message){
        super(message);
    }
}
