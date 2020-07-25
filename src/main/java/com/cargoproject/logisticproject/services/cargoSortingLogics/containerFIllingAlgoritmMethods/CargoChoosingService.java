package com.cargoproject.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.cargoproject.logisticproject.domain.Cargo;
import com.cargoproject.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CargoChoosingService {

    public Cargo chooseCargo(List<Cargo> cargoList, Point length) {
        //можно что нибудь всунуть в  расстояния до объектов по Хlenght и Уlenght от выбранной ТП
        for (Cargo cargo : cargoList) {
            //----проблема разности сторон = если можно вместить Х по У ?!//45 строка в ContainerFillingAlgorithm
            if (cargo.getContainerNumber() == null) {
                if (length.getValueY() >= cargo.getLength()) {
                    if (length.getValueX() >= cargo.getWidth()) {
                        return cargo;
                    }
                }
            }
        }
        return null;
    }
} 