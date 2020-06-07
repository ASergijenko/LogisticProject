package com.logisticproject.services.cargoSortingLogics;

import com.logisticproject.constants.TwentyFootContainer;

public class AdditionalMethods {

    private final Variables variables;

    public AdditionalMethods(Variables variables) {
        this.variables = variables;
    }

    public void setKSTKwithMaximumAreaToTPMK() {
        //Находим КСТК с максимальной площ. из Репозитория КСТК
        //...
        variables.setTPMK(1, 1);//1 заменить на найденные значения
    }

    public Integer setTPfromRepositoryKSTK() {
        //Берем первую точку КСТК - по ID - отсортированные по возрастанию У
        // КСТК из репозитория = Точка построения
        //...
        variables.setTP(1, 1);//1 заменить на найденные значения
        return null;//null заменить на порядковый номер КСТК
    }

    public void designationSmallContainerBorders(int numberActualKSTK) {
        //обозначение границ малого "кармана"
        int KSTKnextYaxis;
        if (repositoryKSTKcontainsNextPoint(numberActualKSTK)) {
            KSTKnextYaxis = 0;//0 заменить на У координаты следующей точки КСТК (numberKSTK++)
        } else {
            KSTKnextYaxis = TwentyFootContainer.LENGTH;
        }

        if (variables.TP_Y_Axis >= variables.TPMK_Y_Axis) {
            variables.Xboard = variables.TPMK_X_Axis - variables.TP_X_Axis;
            variables.Yboard = KSTKnextYaxis - variables.TP_Y_Axis;
        } else {
            variables.Xboard = TwentyFootContainer.WIDTH - variables.TP_X_Axis;
            if (KSTKnextYaxis >= variables.TPMK_Y_Axis) {
                variables.Yboard = variables.TPMK_Y_Axis - variables.TP_Y_Axis;
            } else {
                variables.Yboard = KSTKnextYaxis - variables.TP_Y_Axis;
            }
        }
    }

    public void designationBigContainerBorders() {
        //нахождение границ следующего большого контейнера контейнера от точки TPNK
        //Xboard = TPMK Xvalue
        //Yboard = TPMK Yvalue
        //...
        variables.setBoards(1, 1);//1 заменить на найденные значения
    }

    private boolean repositoryKSTKcontainsNextPoint(int numberActualKSTK) {
        int a = numberActualKSTK++;
        //проверка на содержание  в репозитории следующей после заданной точки (что ближе к дверям - У больше)
        //ловим nullPointException = false
        /*
            return true;
        }*/
        return false;
    }
}
