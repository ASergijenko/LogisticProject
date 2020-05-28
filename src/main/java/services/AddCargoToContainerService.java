package services;

import domain.Cargo;

public class AddCargoToContainerService {

    public Integer[][] addToContainer(Integer startCoordinateLength, Integer startCoordinateWidth, Integer[][] array, Cargo cargo) {
        ///////////VALIDATION IF CONTAINER IS EMPTY THAN COORDINATES 1:1, ELSE REQUIRED FOR COORDINATES


        Integer cargoLength = cargo.getLength();
        Integer cargoWidth = cargo.getWidth();
        Integer cargoNumber = cargo.getCargoId();

        for(Integer i = startCoordinateLength; i < startCoordinateLength + cargoLength; i++) {
            for(Integer j = startCoordinateWidth; j < startCoordinateWidth + cargoWidth; j++) {
                array[i][j] = cargoNumber;
            }
        }
        return array;
    }
}

