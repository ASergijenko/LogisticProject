package com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CargoChoosingService {

    public Cargo chooseCargo(List<Cargo> cargoList, Point TP_Point, Point length, Point boards) {
        //можно что нибудь всунуть в  расстояния до объектов по Хlenght и Уlenght от выбранной ТП
        for (Cargo cargo : cargoList) {
            //----проблема разности сторон = если можно вместить Х по У ?!//45 строка в ContainerFillingAlgorithm
            if (cargo.getContainerNumber() == null) {
                if (TP_Point.getValueY() + length.getValueY() <= boards.getValueY() && TP_Point.getValueY() + length.getValueY() <= cargo.getLength()) {
                    if (TP_Point.getValueX() + length.getValueX() <= boards.getValueX() && TP_Point.getValueX() + length.getValueX() <= cargo.getWidth()) {
                        return cargo;
                    }
                }
            }
        }
        return null;
    }
}