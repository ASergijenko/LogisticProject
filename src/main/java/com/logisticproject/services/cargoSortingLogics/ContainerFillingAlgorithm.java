package com.logisticproject.services.cargoSortingLogics;

import com.logisticproject.constants.TwentyFootContainer;
import com.logisticproject.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContainerFillingAlgorithm {

    @Autowired private Variables variables;

    private int Xlength;
    private int Ylength;

    public void containerFilling() {
        //Алгоритм заполнения контейнера
        boolean newCargoCanBeInsert = true;
        do {
            lengthCalculation();
            if (existCargoForFindedLength()) {
                //>>>>>
                Cargo selectedCargo = null;//null заменить на найденные значения
                //Из DB1 Выбираем груз:
                //    *с пустым полем Container number;
                //    *  с самой длинной стороной У
                //<<<<<
                if (selectedCargo.getLength() <= Xlength * 0.90) {
                    //>>>>>
                    //меняем значения сторон cargo (Х и У)
                    //<<<<<
                }
                //>>>>>
                //Устанавливанем груз в точку построения
                //<<<<<
                selectedCargo.setContainerNumber(variables.containerNumber);
                //>>>>>
                //Нахождение двух точек КСТК
                //<<<<<

                // >>>>>
                //Перезапись точки построения
                //Т.П.== выбранная КСТК, что ближе к точке постоения прошлой фигуры
                //<<<<<

            } else {
                newCargoCanBeInsert = false;
            }
            //>>>>>
            //удаление выбранной КСТК из репозитория
            //<<<<<
        } while (newCargoCanBeInsert);
    }

    private void lengthCalculation() {
        //Нахождение растояния по X и Y до препятствия от точки построения, не больше Xboard и  Yboard
        //...

        Xlength = 0;//0 заменить на найденные значения
        Ylength = 0;//0 заменить на найденные значения
    }

    private boolean existCargoForFindedLength() {
        //можно что нибудь всунуть в  расстояния до объектов по Хlenght и Уlenght от выбранной ТП
        //итерация по DB1...
        int cargoAxisY = 0;//0 заменить на размеры груза
        int cargoAxisX = 0;//0 заменить на размеры груза
        if (variables.TP_Y_Axis + Ylength <= variables.Yboard && variables.TP_Y_Axis + Ylength <= cargoAxisY) {
            if (variables.TP_X_Axis + Xlength <= variables.Xboard && variables.TP_X_Axis + Xlength <= cargoAxisX) {
                return true;
            }
        }
        return false;
    }

}
