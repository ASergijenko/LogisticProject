package com.logisticproject.services.excelService.validations;

public class ValidationException extends RuntimeException{

    public ValidationException(String message){
        super(message);
    }
}
