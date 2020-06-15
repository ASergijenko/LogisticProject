package com.logisticproject.services.cargoSortingLogics.pocketFillingMethods;

import com.logisticproject.constants.TwentyFootContainer;
import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DesignationSmallContainerBorders {

    public Point designateBorders(List<Point> points, Point TPMK_point, Point TPMK_2_point, Point boards) {
        int nextKSTK_Y_Axis = 0;

        for (Point point : points) {
            if (point.getValueY() > TPMK_2_point.getValueY()) {
                nextKSTK_Y_Axis = point.getValueY();
            } else {
                nextKSTK_Y_Axis = TwentyFootContainer.LENGTH;
            }
        }
            if (TPMK_2_point.getValueY() >= TPMK_point.getValueY()) {
                boards.setxValue(TPMK_point.getValueX() - TPMK_2_point.getValueX());
                boards.setyValue(nextKSTK_Y_Axis - TPMK_2_point.getValueY());
            } else {
                boards.setxValue(TwentyFootContainer.WIDTH - TPMK_2_point.getValueX());
            }
            if (nextKSTK_Y_Axis >= TPMK_point.getValueY()) {
                boards.setyValue(TPMK_point.getValueY() - TPMK_2_point.getValueY());
            } else {
                boards.setyValue(nextKSTK_Y_Axis - TPMK_2_point.getValueY());
            }
            return boards;
        }
    }


/*    public void designationSmallContainerBorders(int numberActualKSTK) {
        //обозначение границ малого "кармана"
        int KSTKnextYaxis;
        if (repositoryKSTKcontainsNextPoint(numberActualKSTK)) {
            KSTKnextYaxis = 0;//0 заменить на У координаты следующей точки КСТК (numberKSTK++)
        } else {
            KSTKnextYaxis = TwentyFootContainer.LENGTH;
        }

        if (variables.TP_Y_Axis(tpmk2) >= variables.TPMK_Y_Axis) {
            variables.Xboard = variables.TPMK_X_Axis - variables.tpmk2_X_Axis;
            variables.Yboard = KSTKnextYaxis - variables.tpmk2_Y_Axis;


        } else {
            variables.Xboard = TwentyFootContainer.WIDTH - variables.tpmk2_X_Axis;
            if (KSTKnextYaxis >= variables.TPMK_Y_Axis) {
                variables.Yboard = variables.TPMK_Y_Axis - variables.tpmk2_Y_Axis;
            } else {
                variables.Yboard = KSTKnextYaxis - variables.tpmk2_Y_Axis;
            }
        }
    }*/