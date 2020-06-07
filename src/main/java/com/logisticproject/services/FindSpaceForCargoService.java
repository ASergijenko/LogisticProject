package com.logisticproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class FindSpaceForCargoService {

    @Autowired private FindTemporaryCoordinatesService findTemporaryCoordinatesService;

    public Integer[] coordinatesForCargo(Integer[][] container/*, Cargo cargo*/) {
        Integer[] array = new Integer[2];
        ArrayList<Map<Integer, Integer>> freeCoordinatesForNow = findTemporaryCoordinatesService.findTemporaryCoordinates(container);

        //validation, rotation of cargo, deleting of unsuitable coordinates?
        //something with container and cargo

        for (Map<Integer, Integer> coordinates : freeCoordinatesForNow) {
            for (Integer key : coordinates.keySet()) {
                array[0] = key;
                array[1] = coordinates.get(key);
            }
        }
        return array;
    }
}