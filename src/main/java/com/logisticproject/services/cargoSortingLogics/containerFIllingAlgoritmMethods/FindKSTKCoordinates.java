package com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.logisticproject.constants.TwentyFootContainer;
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
        points.add(pointInX);
        points.add(pointInY);

        //ограничения на точки что пересекают границы контейнера
        for (int i = points.size(); i > 0; i--) {
            Point point = points.get(i - 1);
            if (point.getValueY() > TwentyFootContainer.LENGTH || point.getValueX() > TwentyFootContainer.WIDTH) {
                points.remove(point);
            }
        }
        return points;
    }
}