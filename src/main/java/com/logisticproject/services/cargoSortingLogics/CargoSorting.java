package com.logisticproject.services.cargoSortingLogics;

import com.logisticproject.constants.TwentyFootContainer;
import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Container;
import com.logisticproject.domain.Point;
import com.logisticproject.dto.CargoDTO;
import com.logisticproject.services.cargoSortingLogics.cargoSortingMethods.ContainerCreationService;
import com.logisticproject.services.excelService.ContainerToConsoleViewService;
import com.logisticproject.services.cargoSortingLogics.cargoSortingMethods.FindMaxSquareKSTK;
import com.logisticproject.services.cargoSortingLogics.cargoSortingMethods.ContainerFullnessCheck;
import com.logisticproject.services.cargoSortingLogics.cargoSortingMethods.ExistsNotUsedCargo;
import com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods.FindKSTKCoordinates;
import com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods.RemovePointFromRepository;
import com.logisticproject.services.cargoSortingLogics.pocketFillingMethods.DesignationSmallContainerBorders;
import com.logisticproject.services.cargoSortingLogics.pocketFillingMethods.FindTPPointFromKSTK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CargoSorting {

    @Autowired
    private ContainerCreationService containerCreationService;
    @Autowired
    private ContainerFillingAlgorithm containerFillingAlgorithm;
    @Autowired
    private ExistsNotUsedCargo existsNotUsedCargo;
    @Autowired
    private FindKSTKCoordinates findKSTKCoordinates;
    @Autowired
    private ContainerFullnessCheck containerFullnessCheck;
    @Autowired
    private FindMaxSquareKSTK findMaxSquareKSTK;
    @Autowired
    private FindTPPointFromKSTK findTPPointFromKSTK;
    @Autowired
    private RemovePointFromRepository removePointFromRepository;
    @Autowired
    private DesignationSmallContainerBorders designationSmallContainerBorders;

    @Autowired
    private ContainerToConsoleViewService containerToConsoleViewService;

    public Integer containerNumber = 0;

    public Map<Integer, Integer[][]> cargoSortingProcess(List<Cargo> cargoList) {
        boolean cargoRemained = true;
        boolean containerFinished = false;
        Map<Integer, Integer[][]> containerList = new HashMap<>();
        List<Point> pointsRepository = new ArrayList<>();

        //Сортировка грузов
        do {
            if (existsNotUsedCargo.check(cargoList)) {
                //Создание контейнера
                Container container = new Container(TwentyFootContainer.LENGTH, TwentyFootContainer.WIDTH, containerNumber++);
                Integer[][] containerArray = containerCreationService.create(container.getContainerLength(), container.getContainerWidth());
                containerList.put(container.getContainerNumber(), containerArray);

                Point TPNK_Point = new Point(1, 1);
                Point TP_Point = new Point(1, 1);
                pointsRepository.add(TP_Point);
                Point boards = new Point(TwentyFootContainer.WIDTH, TwentyFootContainer.LENGTH);

                //Заполнение контейнера
                System.out.println("Filling started");//test
                do {
                    //Алгоритм заполнения контейнера
                    System.out.println("Алгоритм заполнения контейнера #1");//test
                    CargoDTO cargoDTO = containerFillingAlgorithm.containerFilling(cargoList, containerList, pointsRepository, TP_Point, TPNK_Point, boards, containerNumber, container);
                    cargoList = cargoDTO.getCargoList();
                    containerList = cargoDTO.getContainerList();
                    pointsRepository = cargoDTO.getPointRepository();
                    container = cargoDTO.getContainer();
                    if (containerFullnessCheck.isSuitableCargo(cargoList, container, pointsRepository)) {
                        //Находим КСТК с максимальной площ. из Репозитория КСТК
                        TPNK_Point = findMaxSquareKSTK.find(pointsRepository);
                        pointsRepository = removePointFromRepository.remove(TPNK_Point, pointsRepository);
                        System.out.println("TPNK " + TPNK_Point);//test

                        //Заполнение "карманов"
                        while (!pointsRepository.isEmpty()) {
                            System.out.println("Заполнение карманов");//test
                            System.out.println("Repository points карманов " + pointsRepository);//test
                            //Берем первую y => 0 точку КСТК из репозитория = Точка построения _2
                            Point TPNK_2_Point = findTPPointFromKSTK.find(pointsRepository);
                            pointsRepository = removePointFromRepository.remove(TPNK_2_Point, pointsRepository);
                            List<Point> pointsRepository2 = new ArrayList<>();
                            pointsRepository2.add(TPNK_2_Point);

                            //обозначение границ малого "кармана"
                            boards = designationSmallContainerBorders.designateBorders(pointsRepository2, TPNK_Point, TPNK_2_Point);
//                            System.out.println("-Границы построения - " + boards + " from " + TPNK_2_Point);//test
                            //Алгоритм заполнения контейнера
                            System.out.println("Алгоритм заполнения контейнера #2");//test
                            cargoDTO = containerFillingAlgorithm.containerFilling(cargoList, containerList, pointsRepository2, TP_Point, TPNK_2_Point, boards, containerNumber, container);
                            cargoList = cargoDTO.getCargoList();
                            containerList = cargoDTO.getContainerList();
                            container = cargoDTO.getContainer();//Fix
                        }
                        //нахождение границ следующего большого контейнера
                        boards.setxValue(TPNK_Point.getValueX());
                        boards.setyValue(TPNK_Point.getValueY());
                        pointsRepository.add(TPNK_Point);
                    } else {
                        containerFinished = true;
                    }
//                    System.out.println(containerFinished);//test
                    System.out.println();//test
                } while (!containerFinished);
                System.out.println("Container '" + containerNumber + "' is filled;");
                break;//test
            } else {
                cargoRemained = false;
            }
        } while (cargoRemained);
        System.out.println("Cargo position is calculated. You will need '" + containerNumber + "' containers;");
        return containerList;
    }
}