package com.logisticproject.services.cargoSortingLogics.cargoSortingMethods;

import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindMaxSquareKSTK {

    public Point find(List<Point> points) {
        Point result = new Point(0,0);
        for (Point point : points) {
            if (point.getValueY() * point.getValueX() > result.getValueY() * result.getValueX()) {
                result = point;
            }
        //return Collections.max(points, Comparator.comparing(constructionPoint -> constructionPoint.getValueY() * constructionPoint.getValueY()));
        }
        return result;
    }
}