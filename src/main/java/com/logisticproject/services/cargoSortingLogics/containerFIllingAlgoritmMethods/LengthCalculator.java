package com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

@Component
public class LengthCalculator {

    public Point calculateLength(Integer[][] containerArray, Point TPNK_Point, Point TP_Point, Point boards) {
        //Нахождение растояния по X и Y до препятствия от точки построения, не больше Xboard и  Yboard от ТПМК
        int xIterations = 0;
        int yIterations = 0;

        int maxX = TPNK_Point.getValueX() + boards.getValueX();
        int maxY = TPNK_Point.getValueY() + boards.getValueY();

        for (int i = 0; i < maxX; i++) {
            xIterations++;
            if (containerArray[TP_Point.getValueY()][i] != null) {
                i = maxX;
                xIterations--;
            }
        }

        for (int i = 0; i < maxY; i++) {
            yIterations++;
            if (containerArray[i][TP_Point.getValueX()] != null) {
                i = maxY;
                yIterations--;
            }
        }
        return new Point(xIterations, yIterations);
    }
}