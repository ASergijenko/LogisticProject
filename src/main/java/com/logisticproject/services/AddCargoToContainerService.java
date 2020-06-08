package com.logisticproject.services;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

@Component
public class AddCargoToContainerService {

    public Integer[][] addToContainer(Point point, Integer[][] array, Cargo cargo) {

        Integer cargoLength = cargo.getLength();
        Integer cargoWidth = cargo.getWidth();
        Integer cargoNumber = cargo.getCargoId();

        for(Integer i = point.getValueY(); i < point.getValueY() + cargoLength; i++) {
            for(Integer j = point.getValueX(); j < point.getValueX() + cargoWidth; j++) {
                array[i][j] = cargoNumber;
            }
        }
        return array;
    }
}

