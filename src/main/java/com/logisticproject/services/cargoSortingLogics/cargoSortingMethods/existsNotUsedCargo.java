package com.logisticproject.services.cargoSortingLogics.cargoSortingMethods;

import com.logisticproject.domain.Cargo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class existsNotUsedCargo {

    public boolean check(List<Cargo> cargoList) {
        for (Cargo cargo : cargoList) {
            if (cargo.getContainerNumber() == null) {
                return true;
            }
        }
        return false;
    }
}