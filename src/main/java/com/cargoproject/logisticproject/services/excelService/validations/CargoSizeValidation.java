package com.cargoproject.logisticproject.services.excelService.validations;

import com.cargoproject.logisticproject.constants.ErrorMessages;
import com.cargoproject.logisticproject.constants.TwentyFootContainer;
import com.cargoproject.logisticproject.domain.Cargo;

import java.util.ArrayList;
import java.util.List;

public class CargoSizeValidation implements ValidationRule<Cargo> {

    @Override
    public void validate(Cargo newCargo) {
        List<String> errorLogs = new ArrayList<>();

        if (newCargo.getLength() >= newCargo.getWidth()) {
            if (newCargo.getLength() >= TwentyFootContainer.LENGTH) {
                errorLogs.add(ErrorMessages.CARGO_LENGTH);
            }
            if (newCargo.getWidth() >= TwentyFootContainer.WIDTH) {
                errorLogs.add(ErrorMessages.CARGO_WIDTH);
            }
        } else {
            if (newCargo.getLength() > TwentyFootContainer.WIDTH) {
                errorLogs.add(ErrorMessages.CARGO_LENGTH);
            }
            if (newCargo.getWidth() > TwentyFootContainer.LENGTH) {
                errorLogs.add(ErrorMessages.CARGO_WIDTH);
            }
        }

        if (!errorLogs.isEmpty()) {
            throw new ValidationException(errorLogs.toString());
        }
    }
}