package services;

import domain.Cargo;

public class AddCargoToContainerService {

    public int[][] addToContainer(int startCoordinateLength, int startCoordinateWidth, int[][] array, Cargo cargo) {

        int cargoLength = cargo.getLength();
        int cargoWidth = cargo.getWidth();
        int cargoNumber = cargo.getCargoId();

        for(int i = startCoordinateLength; i < startCoordinateLength + cargoLength; i++) {
            for(int j = startCoordinateWidth; j < startCoordinateWidth + cargoWidth; j++) {
                array[i][j] = cargoNumber;
            }
        }
        return array;
    }
}

