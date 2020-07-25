package com.cargoproject.logisticproject.services.cargoSortingLogics.pocketFillingMethods;

import com.cargoproject.logisticproject.constants.TwentyFootContainer;
import com.cargoproject.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindTPPointFromKSTK {
//надо подумать над обьявлением значения точки result
    public Point find(List<Point> points) {
        Point result = new Point(TwentyFootContainer.WIDTH, TwentyFootContainer.LENGTH);
        for (Point point : points) {
            if (point.getValueY() < result.getValueY()) {
                result = point;
            }
        }
        return result;
        //return Collections.min(points, Comparator.comparing(Point::getValueY));
    }
}