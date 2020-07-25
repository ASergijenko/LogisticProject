package com.cargoproject.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.cargoproject.logisticproject.domain.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RemovePointFromRepositoryTest {

    private final RemovePointFromRepository victim = new RemovePointFromRepository();

    @Test
    public void removeTheOnlyPoint() {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1,1));

        List<Point> result = victim.remove(new Point(1,1), pointList);

        assertTrue(result.isEmpty());
        assertEquals(0, result.size());
    }

    @Test
    public void removePoint() {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1,1));
        pointList.add(new Point(2,2));

        List<Point> result = victim.remove(new Point(1,1), pointList);

        assertEquals(new Point(2,2), result.get(0));
        assertEquals(1, result.size());
    }
}