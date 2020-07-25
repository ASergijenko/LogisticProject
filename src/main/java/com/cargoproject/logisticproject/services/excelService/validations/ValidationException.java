package com.cargoproject.logisticproject.services.excelService.validations;

public class ValidationException extends RuntimeException{

    public ValidationException(String message){
        super(message);
    }
}
