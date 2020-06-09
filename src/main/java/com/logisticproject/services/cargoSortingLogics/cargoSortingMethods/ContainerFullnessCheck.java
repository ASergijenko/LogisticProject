package com.logisticproject.services.cargoSortingLogics.cargoSortingMethods;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Container;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContainerFullnessCheck {

    public boolean isSuitableCargo(List<Cargo> cargoList, Container container) {
        for (int i = cargoList.size(); i > 0; i--) {
            if (container.getSquare() >= cargoList.get(i).getSquare()) {
                if (cargoList.get(i) != null) {
                    return true;
                }
            }
        }
        return false;
    }
}