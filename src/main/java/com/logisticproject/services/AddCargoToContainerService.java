package com.logisticproject.services;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.ConstructionPoint;
import org.springframework.stereotype.Component;

@Component
public class AddCargoToContainerService {

    public Integer[][] addToContainer(ConstructionPoint constructionPoint, Integer[][] array, Cargo cargo) {

        Integer cargoLength = cargo.getLength();
        Integer cargoWidth = cargo.getWidth();
        Integer cargoNumber = cargo.getCargoId();

        for(Integer i = constructionPoint.getyValue(); i < constructionPoint.getyValue() + cargoLength; i++) {
            for(Integer j = constructionPoint.getxValue(); j < constructionPoint.getxValue() + cargoWidth; j++) {
                array[i][j] = cargoNumber;
            }
        }
        return array;
    }
}

