package com.cargoproject.logisticproject.services.cargoSortingLogics.pocketFillingMethods;

import com.cargoproject.logisticproject.constants.TwentyFootContainer;
import com.cargoproject.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DesignationSmallContainerBorders {

    public Point designateBorders(List<Point> points, Point TPMK_point, Point TPMK_2_point) {
        Point boards = new Point();
        int nextKSTK_Y_Axis = 0;

        // проверка есть ли след. точку KSTK в репозитории
        for (Point point : points) {
            if (TPMK_2_point.getValueY() < point.getValueY()) {
                nextKSTK_Y_Axis = point.getValueY() ;
                break;
            } else {
                //+1 - коррекция рассчета границ при получении длинны контейнера
                nextKSTK_Y_Axis = TwentyFootContainer.LENGTH + 1;
            }
        }

        if (TPMK_2_point.getValueY() > TPMK_point.getValueY()) {
            boards.setxValue(TPMK_point.getValueX() - TPMK_2_point.getValueX());
            boards.setyValue(nextKSTK_Y_Axis - TPMK_2_point.getValueY());
        } else {
            boards.setxValue(TwentyFootContainer.WIDTH - TPMK_2_point.getValueX());
            if (nextKSTK_Y_Axis > TPMK_point.getValueY()) {
                boards.setyValue(TPMK_point.getValueY() - TPMK_2_point.getValueY());
            } else {
                boards.setyValue(nextKSTK_Y_Axis - TPMK_2_point.getValueY());
            }
        }
        return boards;
    }
}