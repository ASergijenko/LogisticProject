package com.logisticproject.services.excelService.validations;

import com.logisticproject.domain.Cargo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CargoValidationService implements ValidationRule<Cargo> {

    private final List<ValidationRule<Cargo>> validationRules = new ArrayList<>();
    private final List<String> errorLogs = new ArrayList<>();

    public CargoValidationService(){
        validationRules.add(new CargoSizeValidation());
    }

    @Override
    public void validate(Cargo newCargo) {
        for (ValidationRule<Cargo> rule : validationRules) {
            try {
                rule.validate(newCargo);
            } catch (ValidationException e) {
                errorLogs.add(e.getMessage());
            }
        }
        if (!errorLogs.isEmpty()) {
            throw new ValidationException(errorLogs.toString());
        }
    }
}
