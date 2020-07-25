package com.cargoproject.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.cargoproject.logisticproject.domain.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TP_PointCalculationTest {

    private final TP_PointCalculation victim = new TP_PointCalculation();

    @Test
    public void calcTpPointCheckAxisX() {
        Point TP_point = new Point(1, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1, 2));
        pointList.add(new Point(5, 5));

        assertEquals(new Point(1, 2), victim.calcTpPoint(pointList, TP_point, new Point(1, 1)));
    }

    @Test
    public void calcTpPointCheckAxisY() {
        Point TP_point = new Point(1, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(3, 2));
        pointList.add(new Point(5, 5));

        assertEquals(new Point(3, 2), victim.calcTpPoint(pointList, TP_point, new Point(1, 1)));
    }

    @Test
    public void calcTpPointCheckSquare() {
        Point TP_point = new Point(1, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(6, 4));
        pointList.add(new Point(9, 1));

        assertEquals(new Point(9, 1), victim.calcTpPoint(pointList, TP_point, new Point(1, 1)));
    }

    @Test
    public void calcTpPointCheckSquareAxisY() {
        Point TP_point = new Point(1, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(6, 1));
        pointList.add(new Point(4, 3));

        assertEquals(new Point(6, 1), victim.calcTpPoint(pointList, TP_point, new Point(1, 1)));
    }

    @Test
    public void calcTpPointCheckSquareAxisX() {
        Point TP_point = new Point(1, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1, 4));
        pointList.add(new Point(6, 2));

        assertEquals(new Point(1, 4), victim.calcTpPoint(pointList, TP_point, new Point(1, 1)));
    }
}