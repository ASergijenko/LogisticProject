package com.logisticproject.services.validations;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.ContainerTwentyFoot;

public class CargoSizeValidation implements ValidationRule<Cargo> {

    ContainerTwentyFoot containerTwentyFoot = new ContainerTwentyFoot();

    public String lengthErrorMessage = "Cargo length is greater than container length";
    public String widthErrorMessage = "Cargo width is greater than container width";

    @Override
    public void validate(Cargo newCargo) {
        String errorLogs = null;
        if (newCargo.getLength() >= containerTwentyFoot.getLength()) {
            errorLogs = lengthErrorMessage;
        }
        if (newCargo.getWidth() >= containerTwentyFoot.getWidth()) {
            if (errorLogs != null) {
                errorLogs = errorLogs + ", " + widthErrorMessage;
            } else {
                errorLogs = widthErrorMessage;
            }
        }
        if (errorLogs != null) {
            throw new ValidationException(errorLogs);
        }
    }
}