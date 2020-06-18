package com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FindKSTKCoordinates {

    public List<Point> findTemporaryCoordinates(Point TP_point, Cargo createdCargo) {
        List<Point> points = new ArrayList<>();
        Point pointInX = new Point(TP_point.getValueX() + createdCargo.getWidth(), TP_point.getValueY());
        Point pointInY = new Point(TP_point.getValueX(), TP_point.getValueY() + createdCargo.getLength());
        //а надо ли нам это?
        if (pointInX.getValueX() - TP_point.getValueX() < pointInY.getValueY() - TP_point.getValueY()) {
            points.add(0, pointInX);
            points.add(1, pointInY);
        } else {
            points.add(0, pointInY);
            points.add(1, pointInX);
        }
        return points;
    }
}