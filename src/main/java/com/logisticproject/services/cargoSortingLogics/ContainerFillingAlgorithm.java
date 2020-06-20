package com.logisticproject.services.cargoSortingLogics;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Container;
import com.logisticproject.domain.Point;
import com.logisticproject.dto.CargoDTO;
import com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods.FindKSTKCoordinates;
import com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods.AddCargoToContainerService;
import com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods.CargoChoosingService;
import com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods.LengthCalculator;
import com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods.RemovePointFromRepository;
import com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods.TP_PointCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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
    @Autowired
    AddCargoToContainerService addCargoToContainerService;
    @Autowired
    FindKSTKCoordinates findKSTKCoordinates;

    public CargoDTO containerFilling(List<Cargo> cargoList, Map<Integer, Integer[][]> containerList, List<Point> pointRepository, Point TP_Point, Point TPNK_Point, Point boards, Integer containerNumber, Container container) {
        Integer[][] containerArray = containerList.get(containerNumber - 1);          //  Integer[][] containerArray = containerList.get(containerNumber);

        //Алгоритм заполнения контейнера
        boolean newCargoCanBeInsert = true;
        do {
            TP_Point = tp_pointCalculation.calcTpPoint(pointRepository, TP_Point);
            pointRepository = removePointFromRepository.remove(TP_Point, pointRepository);
            Point length = lengthCalculator.calculateLength(containerArray, TPNK_Point, TP_Point, boards);
            Cargo selectedCargo = cargoChoosingService.chooseCargo(cargoList, length);
            if (selectedCargo != null) {
                if (selectedCargo.getLength() <= length.getValueX() * 0.90) {
                    //меняем значения сторон cargo (Х и У)
                    int width = selectedCargo.getWidth();
                    selectedCargo.setWidth(selectedCargo.getLength());
                    selectedCargo.setLength(width);
                }
                //Устанавливанем груз в точку построения
                containerArray = addCargoToContainerService.addToContainer(TP_Point, containerArray, selectedCargo);
                selectedCargo.setContainerNumber(containerNumber);
                container.setSquare(container.getSquare() - selectedCargo.getSquare());

                //Нахождение двух точек КСТК
                List<Point> points_KSTK = findKSTKCoordinates.findTemporaryCoordinates(TP_Point, selectedCargo);
                pointRepository.add(points_KSTK.get(0));
                pointRepository.add(points_KSTK.get(1));
            } else {
                newCargoCanBeInsert = false;
            }
        } while (newCargoCanBeInsert);

        CargoDTO cargoDTO = new CargoDTO();
        cargoDTO.setCargoList(cargoList);
        containerList.put(containerNumber - 1, containerArray);
        cargoDTO.setContainerList(containerList);
        cargoDTO.setPointRepository(pointRepository);
        cargoDTO.setContainer(container);
        return cargoDTO;
    }
}