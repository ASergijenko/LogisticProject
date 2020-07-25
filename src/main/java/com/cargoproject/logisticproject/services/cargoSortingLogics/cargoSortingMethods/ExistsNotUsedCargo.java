package com.cargoproject.logisticproject.services.cargoSortingLogics.cargoSortingMethods;

import com.cargoproject.logisticproject.domain.Cargo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExistsNotUsedCargo {

    public boolean check(List<Cargo> cargoList) {
        for (Cargo cargo : cargoList) {
            if (cargo.getContainerNumber() == null) {
                return true;
            }
        }
        return false;
    }
}