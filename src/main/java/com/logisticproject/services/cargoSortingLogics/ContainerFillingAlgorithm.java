package com.logisticproject.services.cargoSortingLogics;

import com.logisticproject.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContainerFillingAlgorithm {

    @Autowired
    private Variables variables;

    private int Xlength;
    private int Ylength;

    public void containerFilling(Integer[][] containerArray) {

        //Алгоритм заполнения контейнера
        boolean newCargoCanBeInsert = true;
        do {
            lengthCalculation(containerArray);
            if (existCargoForFoundLength()) {
                Cargo selectedCargo = chosenCargo();
                if (selectedCargo.getLength() <= Xlength * 0.90) {
                    //меняем значения сторон cargo (Х и У)
                    int width = selectedCargo.getWidth();
                    selectedCargo.setWidth(selectedCargo.getLength());
                    selectedCargo.setLength(width);
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


    //dorabotatj poljubomu govnokod
    private void lengthCalculation(Integer[][] containerArray) {
        //Нахождение растояния по X и Y до препятствия от точки построения, не больше Xboard и  Yboard от ТПМК
        int xIterations = 0;
        int yIterations = 0;

        int maxX = variables.TPMK_X_Axis + variables.Xboard;
        int maxY = variables.TPMK_Y_Axis + variables.Yboard;

        for (int i = 0; i < maxX; i++) {
            xIterations++;
            if (containerArray[variables.TP_Y_Axis][i] != null) {
//               break;
                i = maxX;
                xIterations--;
            }
        }

        for (int i = 0; i < maxY; i++) {
            yIterations++;
            if (containerArray[i][variables.TP_X_Axis] != null) {
//               break;
                i = maxY;
                yIterations--;
            }
        }

        Xlength = xIterations;
        Ylength = yIterations;
    }
//cjdvtcnbnm ldf vtnjlf
    private boolean existCargoForFoundLength() {
        //можно что нибудь всунуть в  расстояния до объектов по Хlenght и Уlenght от выбранной ТП
        for (Cargo cargo : variables.cargoList) {
            if (variables.TP_Y_Axis + Ylength <= variables.Yboard && variables.TP_Y_Axis + Ylength <= cargo.getLength()) {
                if (variables.TP_X_Axis + Xlength <= variables.Xboard && variables.TP_X_Axis + Xlength <= cargo.getWidth()) {
                    return true;
                }
            }
        }
        return false;
    }

    private Cargo chosenCargo() {
        //Из DB1 Выбираем груз:
        //    *с пустым полем Container number;
        //    *  с самой длинной стороной У


        Cargo chosenCargo = new Cargo();
        for (Cargo cargo : variables.cargoList) {
            if (cargo.getContainerNumber() == null) {
                if (cargo.getLength() > chosenCargo.getLength()) {
                    chosenCargo = cargo;
                }
            }
        }
        return chosenCargo;
    }

}
