package com.logisticproject.services.cargoSortingLogics;

import com.logisticproject.constants.TwentyFootContainer;

public class SortingMain {
    //>>>>>
    //будет добавлена  логика
    //<<<<<

    private final Variables variables = new Variables();
    private final ContainerFillingAlgorithm containerFillingAlgorithm = new ContainerFillingAlgorithm(variables);
    private final AdditionalMethods additionalMethods = new AdditionalMethods(variables);

    public void cargoSortingProcess() {
        boolean cargoRemained = true;
        boolean containerFinished = false;
        boolean leftAnyKSTK = true;

        do {
            //Сортировка грузов

            //>>>>>
            //Еще остались грузы в DB1?
            if (true) {//true заменить на логику ДА
                //<<<<<
                variables.containerNumber++;
                variables.setTPMK(1, 1);
                variables.setBoards(TwentyFootContainer.WIDTH, TwentyFootContainer.LENGTH);
                do {
                    //Заполнение контейнера

                    //>>>>>
                    //Алгоритм заполнения контейнера
                    containerFillingAlgorithm.containerFilling();
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
                            containerFillingAlgorithm.containerFilling();
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
    }
}
