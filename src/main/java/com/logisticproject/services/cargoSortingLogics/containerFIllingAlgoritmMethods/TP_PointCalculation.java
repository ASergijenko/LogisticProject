package com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TP_PointCalculation {

    public Point calcTpPoint(List<Point> pointRepository, Point TP_Point) {
        //Точка построение = точка из репозитория КСТК с ближайщими кардинатами к ТПМК
        Point result = TP_Point;
        int sumOfTP = TP_Point.getValueX() + TP_Point.getValueY();
        int temp = 100000;

        for (Point point : pointRepository) {
            int sumOfPoint = point.getValueX() + point.getValueY();
            if (sumOfPoint - sumOfTP < temp) {
                temp = sumOfPoint - sumOfTP;
                result = point;
            }
        }
        return result;
    }
}