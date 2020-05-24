package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindFreeCoordinatesForNowService {

    public ArrayList<Map<Integer, Integer>> findCoordinates(Integer[][] array) {
        ArrayList<Map<Integer, Integer>> coordinatesList = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            outerloop:
            for(int j = 0; j < array[0].length; j++) {
                for (Map<Integer, Integer> coordinates : coordinatesList) {
                    if (coordinates.containsKey(i) || coordinates.containsValue(j)) {
                        break outerloop;
                    }
                }
                if (array[i][j] == null) {
                    Map<Integer, Integer> found = new HashMap<>();
                    found.put(i, j);
                    coordinatesList.add(found);
                }
            }
        }
        return coordinatesList;
    }
}