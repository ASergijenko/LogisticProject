package com.logisticproject.services.cargoSortingLogics.pocketFillingMethods;

import com.logisticproject.constants.TwentyFootContainer;
import com.logisticproject.domain.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindTPPointFromKSTKTest {

    private final FindTPPointFromKSTK victim = new FindTPPointFromKSTK();

    @Test
    public void find() {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(2,5));
        pointList.add(new Point(4,10));

        assertEquals(new Point(2,5), victim.find(pointList));
    }

    @Test
    public void findEmpty() {
        assertEquals(new Point(TwentyFootContainer.WIDTH, TwentyFootContainer.LENGTH), victim.find(new ArrayList<>()));
    }
}