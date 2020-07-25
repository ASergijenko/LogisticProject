package com.cargoproject.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.cargoproject.logisticproject.constants.TwentyFootContainer;
import com.cargoproject.logisticproject.domain.Cargo;
import com.cargoproject.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FindKSTKCoordinates {

    public List<Point> findTemporaryCoordinates(Point TP_point, Point TPNK_point, Cargo createdCargo, Point length) {
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
//            System.out.println(length.getValueY() + TPNK_point.getValueY());//test
//            if (point.getValueY() >= length.getValueY() + TPNK_point.getValueY() || point.getValueX() >= length.getValueX() + TPNK_point.getValueX()) {
//                points.remove(point);
//            }
        }

        return points;
    }
}