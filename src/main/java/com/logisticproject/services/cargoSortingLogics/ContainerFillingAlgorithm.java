package com.logisticproject.services.cargoSortingLogics;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Point;
import com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods.CargoChoosingService;
import com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods.LengthCalculator;
import com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods.RemovePointFromRepository;
import com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods.TP_PointCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContainerFillingAlgorithm {

    @Autowired
    TP_PointCalculation tp_pointCalculation;
    @Autowired
    RemovePointFromRepository removePointFromRepository;
    @Autowired
    LengthCalculator lengthCalculator;
    @Autowired
    CargoChoosingService cargoChoosingService;

    public void containerFilling(List<Cargo> cargoList, Integer[][] containerArray, List<Point> pointRepository, Point TP_Point, Point TPNK_Point, Point boards) {

        //Алгоритм заполнения контейнера
        boolean newCargoCanBeInsert = true;
        do {
            TP_Point = tp_pointCalculation.calcTpPoint(pointRepository, TP_Point, TPNK_Point);
            pointRepository = removePointFromRepository.removePointFromRepository(TP_Point, pointRepository);
            Point length = lengthCalculator.calculateLength(containerArray, TPNK_Point, TP_Point, boards);
            Cargo selectedCargo = cargoChoosingService.chooseCargo(cargoList, TP_Point, length, boards);
            if (selectedCargo != null) {
                if (selectedCargo.getLength() <= length.getValueX() * 0.90) {
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
}
