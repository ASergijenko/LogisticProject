package services;

import java.util.HashMap;
import java.util.Map;

public class FindFreeCoordinatesForNowService {

    public Map<Integer, Integer> findCoordinates(int[][] array) {
        Map<Integer, Integer> coordinatesList = new HashMap();

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                if (coordinatesList.containsKey(i) || coordinatesList.containsValue(j)) {
                    break;
                }
                if (array[i][j] == 0) {
                    coordinatesList.put(i, j);
                }
            }
        }
        return coordinatesList;
    }
}