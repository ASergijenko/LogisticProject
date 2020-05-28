package com.logisticproject.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class FindSpaceForCargoService {

    public Integer[] coordinatesForCargo(Integer[][] container/*, Cargo cargo*/) {
        Integer[] array = new Integer[2];
        FindFreeCoordinatesForNowService findFreeCoordinatesForNowService = new FindFreeCoordinatesForNowService();
        ArrayList<Map<Integer, Integer>> freeCoordinatesForNow = findFreeCoordinatesForNowService.findCoordinates(container);

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