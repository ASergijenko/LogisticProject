package com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TP_PointCalculation {

    public Point calcTpPoint(List<Point> pointRepository, Point TP_Point, Point TPNK_Point) {
        Point result = TP_Point;
        int sumOfTPNK = TPNK_Point.getValueX() + TPNK_Point.getValueY();
        int temp = 100000;

        for (Point point : pointRepository) {
            int sumOfPoint = point.getValueX() + point.getValueY();
            if (sumOfPoint - sumOfTPNK < temp){
                temp = sumOfPoint - sumOfTPNK;
                result = point;
            }
        }
        return result;
    }
}