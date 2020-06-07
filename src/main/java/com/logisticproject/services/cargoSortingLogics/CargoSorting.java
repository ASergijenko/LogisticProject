package com.logisticproject.services.cargoSortingLogics;

import com.logisticproject.constants.TwentyFootContainer;
import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.ConstructionPoint;
import com.logisticproject.domain.Container;
import com.logisticproject.services.ContainerCreationService;
import com.logisticproject.services.FindTemporaryCoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CargoSorting {

    @Autowired private ContainerCreationService containerCreationService;
    @Autowired private Variables variables;
    @Autowired private ContainerFillingAlgorithm containerFillingAlgorithm;
    @Autowired private AdditionalMethods additionalMethods;
    @Autowired private FindTemporaryCoordinatesService findTemporaryCoordinatesService;

    //>>>>>
    //будет добавлена  логика
    //<<<<<

    public Map<Integer, Integer[][]> cargoSortingProcess() {
        boolean cargoRemained = true;
        boolean containerFinished = false;
        boolean leftAnyKSTK = true;
        Map<Integer, Integer[][]> containerList = new HashMap<>();

        do {
            //Сортировка грузов
            if (additionalMethods.existNotUsedCargo()) {
                //Создание контейнера
                Container container = new Container(TwentyFootContainer.LENGTH, TwentyFootContainer.WIDTH, variables.containerNumber++);
                Integer[][] containerArray = containerCreationService.create(container.getContainerLength(), container.getContainerWidth());
                containerList.put(container.getContainerNumber(), containerArray);

                //     ConstructionPoint constructionPoint = new ConstructionPoint(1,1);
                variables.setTPMK(1, 1);
                variables.setTP(1,1);
                variables.setBoards(TwentyFootContainer.WIDTH, TwentyFootContainer.LENGTH);
                do {
                    //Заполнение контейнера

                    //>>>>>
                    //Алгоритм заполнения контейнера
                    containerFillingAlgorithm.containerFilling(containerArray);
                    //<<<<<

                    //>>>>>
                    //Анализ container Fullness
                    if (true) {//true заменить на логику ДА
                        //<<<<<

                        //>>>>>
                        //Находим КСТК с максимальной площ. из Репозитория КСТК
                        additionalMethods.setKSTKwithMaximumAreaToTPMK();
                        //<<<<<
                        do{
                            //Заполнение "карманов"

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
