package com.logisticproject.services.cargoSortingLogics.cargoSortingMethods;

import org.springframework.stereotype.Component;

@Component
public class ContainerCreationService {

    public Integer[][] create(int length, int width) {
        Integer[][] array = new Integer[length + 2][width + 2];
        for (int i = 0; i < length + 1; i++){
            for (int j = 0; j <= width + 1; j++){
                array[length + 1][j] = 0;//test
                array[0][j] = 0;//test
                array[length + 1][j] = j;
                array[0][j] = j;
            }
//            array[i][width + 1] = 0;
//            array[i + 1][0] = 0;
            array[i][width + 1] = i;//test
            array[i + 1][0] = i+1;//test
        }
        return array;
    }
}