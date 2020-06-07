package com.logisticproject.services.cargoSortingLogics;

public class AdditionalMethods {

    private final Variables variables;

    public AdditionalMethods(Variables variables) {
        this.variables = variables;
    }

    public void setKSTKwithMaximumAreaToTPNK() {
        //Находим КСТК с максимальной площ. из Репозитория КСТК
        //...
        variables.setTPMK(1, 1);//1 заменить на найденные значения
    }

    public void setTPfromRepositoryKSTK() {
        //Берем первую точку КСТК - по ID?
        // КСТК из репозитория = Точка построения
        //...
        variables.setTP(1, 1);//1 заменить на найденные значения
    }

    public void designationSmallContainerBorders() {
        //обозначение границ малого "кармана"
        //...
        variables.setBoards(1, 1);//1 заменить на найденные значения
    }

    public void designationBigContainerBorders() {
        //нахождение границ следующего большого контейнера контейнера от точки TPNK
        //Xboard = TPNK Xvalue
        //Yboard = TPNK Yvalue
        //...
        variables.setBoards(1, 1);//1 заменить на найденные значения
    }
}
