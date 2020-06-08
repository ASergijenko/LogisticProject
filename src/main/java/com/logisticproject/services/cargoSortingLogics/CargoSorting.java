package com.logisticproject.services.cargoSortingLogics;

import com.logisticproject.constants.TwentyFootContainer;
import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Point;
import com.logisticproject.domain.Container;
import com.logisticproject.services.ContainerCreationService;
import com.logisticproject.services.FindTemporaryCoordinatesService;
import com.logisticproject.services.cargoSortingLogics.util.AdditionalMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CargoSorting {

    @Autowired private ContainerCreationService containerCreationService;
    @Autowired private ContainerFillingAlgorithm containerFillingAlgorithm;
    @Autowired private AdditionalMethods additionalMethods;
    @Autowired private FindTemporaryCoordinatesService findTemporaryCoordinatesService;

    //>>>>>
    //будет добавлена  логика
    //<<<<<

    public Map<Integer, Integer[][]> cargoSortingProcess(List<Cargo> cargoList) {
        boolean cargoRemained = true;
        boolean containerFinished = false;
        boolean leftAnyKSTK = true;

        int containerNumber = 0;

        Map<Integer, Integer[][]> containerList = new HashMap<>();
        List<Point> pointsRepository = new ArrayList<>();

        //Сортировка грузов
        do {
            if (additionalMethods.existNotUsedCargo(cargoList)) {

                //Создание контейнера
                Container container = new Container(TwentyFootContainer.LENGTH, TwentyFootContainer.WIDTH, containerNumber++);
                Integer[][] containerArray = containerCreationService.create(container.getContainerLength(), container.getContainerWidth());
                containerList.put(container.getContainerNumber(), containerArray);

                Point TPNK_Point = new Point(1,1);
                Point TP_Point = new Point(1,1);
                pointsRepository.add(TP_Point);
                Point boards = new Point(TwentyFootContainer.WIDTH, TwentyFootContainer.LENGTH);

                //Заполнение контейнера
                do {
                    //Алгоритм заполнения контейнера
                    containerFillingAlgorithm.containerFilling(cargoList, containerArray, pointsRepository, TP_Point, TPNK_Point, boards);







                    //Анализ container Fullness
                    if (true) {//true заменить на логику ДА
                        //<<<<<

                        //>>>>>
                        //Находим КСТК с максимальной площ. из Репозитория КСТК
                        additionalMethods.setKSTKwithMaximumAreaToTPMK();
                        //<<<<<

                        //Заполнение "карманов"
                        do{

                            //>>>>>
                            //Берем первую точку КСТК из репозитория = Точка построения
                            int numberActualKSTK = additionalMethods.setTPfromRepositoryKSTK();
                            //<<<<<

                            //>>>>>
                            //обозначение границ малого "кармана"
                            additionalMethods.designationSmallContainerBorders(numberActualKSTK);
                            //<<<<<

                            //>>>>>
                            //Алгоритм заполнения контейнера
                            containerFillingAlgorithm.containerFilling(containerArray);
                            //<<<<<

                            //>>>>>
                            //Еще осталичсь КСТК?
                            if (false) {//false заменить на логику НЕТ
                                //<<<<<
                                leftAnyKSTK=false;
                            }
                        }while (leftAnyKSTK);

                        //>>>>>
                        //нахождение границ следующего большого контейнера
                        additionalMethods.designationBigContainerBorders();
                        //<<<<<

                    } else {
                        containerFinished = true;
                    }
                } while (!containerFinished);
                System.out.println("Container '"+ variables.containerNumber + "' is filled;");
            } else {
                cargoRemained = false;
            }
        } while (cargoRemained);
        System.out.println("Cargo position is calculated. You will need '" + variables.containerNumber + "' containers;");

    return containerList;
    }
}