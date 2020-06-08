package com.logisticproject.services;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FindTemporaryCoordinatesService {

    public List<Point> findTemporaryCoordinates(Point point, Cargo createdCargo) {
        List<Point> points = new ArrayList<>();
        Point newPoint;
        Integer xValue = 1;
        Integer yValue = 1;
        if (point.getValueX().equals(xValue) && point.getValueY().equals(yValue)) {
            newPoint = point;
            points.add(newPoint);
        } else {
            Point pointInX = new Point(point.getValueX() + createdCargo.getWidth(), point.getValueY());
            Point pointInY = new Point(point.getValueX(), point.getValueY() + createdCargo.getLength());
            if (pointInX.getValueX() - point.getValueX() < pointInY.getValueY() - point.getValueY()) {
                points.add(0, pointInX);
                points.add(1, pointInY);
            } else if (pointInY.getValueY() - point.getValueY() < pointInX.getValueX() - point.getValueX()) {
                points.add(0, pointInY);
                points.add(1, pointInX);
            } else {
                points.add(0, pointInX);
                points.add(1, pointInY);
            }
        }
    return points;
    }
}