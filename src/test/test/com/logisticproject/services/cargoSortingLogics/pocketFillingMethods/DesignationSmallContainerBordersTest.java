package com.logisticproject.services.cargoSortingLogics.pocketFillingMethods;

import com.logisticproject.constants.TwentyFootContainer;
import com.logisticproject.domain.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DesignationSmallContainerBordersTest {

    private final DesignationSmallContainerBorders victim = new DesignationSmallContainerBorders();

    @Test
    public void designateBordersZeroX() {
        Point TPMK_point = new Point(20, 40);
        Point TPMK_2_point = new Point(50, 0);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(30, 20));

        assertEquals(new Point(TwentyFootContainer.WIDTH - 50, 20), victim.designateBorders(pointList, TPMK_point, TPMK_2_point));
    }

    @Test
    public void designateBordersHigherTPNK_2_BetweenKSTK() {
        Point TPMK_point = new Point(20, 40);
        Point TPMK_2_point = new Point(15, 10);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(50, 0));
        pointList.add(new Point(30, 20));

        assertEquals(new Point(TwentyFootContainer.WIDTH - 15, 10), victim.designateBorders(pointList, TPMK_point, TPMK_2_point));
    }

    @Test
    public void designateBordersHigherTPNK_2() {
        Point TPMK_point = new Point(20, 40);
        Point TPMK_2_point = new Point(30, 20);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(50, 0));
        pointList.add(new Point(15, 50));

        assertEquals(new Point(TwentyFootContainer.WIDTH - 30, 20), victim.designateBorders(pointList, TPMK_point, TPMK_2_point));
    }

    @Test
    public void designateBordersBelowTPNK_2() {
        Point TPMK_point = new Point(20, 40);
        Point TPMK_2_point = new Point(15, 50);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(30, 20));
        pointList.add(new Point(0, 60));

        assertEquals(new Point(5, 10), victim.designateBorders(pointList, TPMK_point, TPMK_2_point));
    }

    @Test
    public void designateBordersBelowTPNK_2BetweenKSTK() {
        Point TPMK_point = new Point(20, 40);
        Point TPMK_2_point = new Point(10, 55);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(15, 50));
        pointList.add(new Point(0, 60));

        assertEquals(new Point(10, 5), victim.designateBorders(pointList, TPMK_point, TPMK_2_point));
    }

    @Test
    public void designateBordersZeroY() {
        Point TPMK_point = new Point(20, 40);
        Point TPMK_2_point = new Point(0, 60);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(15, 50));

        assertEquals(new Point(20, TwentyFootContainer.LENGTH - 60), victim.designateBorders(pointList, TPMK_point, TPMK_2_point));
    }
}