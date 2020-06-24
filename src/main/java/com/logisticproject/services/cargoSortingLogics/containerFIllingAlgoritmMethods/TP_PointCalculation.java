package com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TP_PointCalculation {

    public Point calcTpPoint(List<Point> pointRepository, Point TP_Point, Point TPNK_Point) {
        //Точка построение = точка из репозитория КСТК с ближайщими кардинатами к ТПМК
        Point result = null;
        int sumOfTP = TP_Point.getValueX() + TP_Point.getValueY();
        int temp = 100000;

        for (Point point : pointRepository) {
            int sumOfPoint = point.getValueX() + point.getValueY();
            if (sumOfPoint - sumOfTP < temp) {
                temp = sumOfPoint - sumOfTP;
                result = point;
            }
            //new - если квадрат то надо выбрать на одной оси с первой точкой TPNK
            else if (sumOfPoint == (result.getValueY() + result.getValueX())) {
                if (TPNK_Point.getValueX().equals(point.getValueX()) || TPNK_Point.getValueY().equals(point.getValueY())) {
                    result = point;
                }
            }
        }
        return result;
    }
}