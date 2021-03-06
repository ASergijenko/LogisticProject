package com.logisticproject.services.cargoSortingLogics.cargoSortingMethods;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Container;
import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContainerFullnessCheck {

    public boolean isSuitableCargo(List<Cargo> cargoList, Container container, List<Point> pointList) {
        if (!pointList.isEmpty()) {//proverit na kucu tocek-logika lomajetsja
            for (int i = cargoList.size() - 1; i >= 0; i--) {
                if (container.getSquare() >= cargoList.get(i).getSquare()) {
                    if (cargoList.get(i).getContainerNumber() == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}