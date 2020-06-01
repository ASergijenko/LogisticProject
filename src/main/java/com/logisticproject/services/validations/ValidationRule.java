package com.logisticproject.services.validations;

import com.logisticproject.domain.Cargo;

public interface ValidationRule<T> {

    void validate(T newCargo);
}
