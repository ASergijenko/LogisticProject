package com.logisticproject.services.cargoSortingLogics.cargoSortingMethods;

import org.springframework.stereotype.Component;

@Component
public class ContainerCreationService {

    public Double[][] create(int length, int width) {
        Double[][] array = new Double[length + 2][width + 2];
        for (int i = 0; i < length + 1; i++){
            for (int j = 0; j <= width + 1; j++){
                array[length + 1][j] = (double) 0;
                array[0][j] = (double) 0;
            }
            array[i][width + 1] = (double) 0;
            array[i + 1][0] = (double) 0;
        }
        return array;
    }
}