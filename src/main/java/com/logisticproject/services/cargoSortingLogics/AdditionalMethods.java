package com.logisticproject.services.cargoSortingLogics;

public class AdditionalMethods {

    private final Variables variables;

    public AdditionalMethods(Variables variables) {
        this.variables = variables;
    }

    public void setKSTKwithMaximumAreaToTPNK() {
        //...
        variables.setTPMK(1, 1);//1 заменить на найденные значения
    }

    public void setTPfromRepositoryKSTK() {
        //Берем первую точку КСТК - по ID?
        //...
        variables.setTP(1, 1);//1 заменить на найденные значения
    }

    public void designationSmallContainerBorders() {
        //...
        variables.setBoards(1, 1);//1 заменить на найденные значения
    }

    public void designationBigContainerBorders() {
        //нахождение границ второго большого контейнера контейнера
        //Xboard = TPNK Xvalue
        //Yboard = TPNK Yvalue
        variables.setBoards(1, 1);//1 заменить на найденные значения
    }
}
