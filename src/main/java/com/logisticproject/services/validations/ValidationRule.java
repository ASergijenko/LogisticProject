package com.logisticproject.services.validations;

public interface ValidationRule<T> {

    void validate(T newCargo);
}
