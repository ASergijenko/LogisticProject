package com.cargoproject.logisticproject.services.excelService.validations;

public interface ValidationRule<T> {

    void validate(T newCargo);
}
