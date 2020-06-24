package com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.logisticproject.domain.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TP_PointCalculationTest {

    private final TP_PointCalculation victim = new TP_PointCalculation();

    @Test
    public void calcTpPointCheckX() {
        Point TP_point = new Point(1,1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1,2));
        pointList.add(new Point(5,5));

        assertEquals(new Point(1, 2), victim.calcTpPoint(pointList, TP_point, new Point(1, 1)));
    }

    @Test
    public void calcTpPointCheckY() {
        Point TP_point = new Point(1,1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(3,2));
        pointList.add(new Point(5,5));

        assertEquals(new Point(3, 2), victim.calcTpPoint(pointList, TP_point, new Point(1, 1)));
    }
}