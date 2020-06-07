package com.logisticproject;

import com.logisticproject.constants.TwentyFootContainer;
import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Container;
import com.logisticproject.services.*;
import com.logisticproject.services.excelService.ExcelReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LogisticExecute {

private ContainerCreationService containerCreationService;
private ContainerToConsoleViewService containerToConsoleViewService;
private AddCargoToContainerService addCargoToContainerService;
private FindTemporaryCoordinatesService findTemporaryCoordinatesService;
private FindSpaceForCargoService findSpaceForCargoService;
private ExcelReadingService reader;
private ListSortingService listSortingService;

    public void execute() throws Exception {

        //////////print parsed data from collection
        //Aleksandr work
        //C:/Users/Aleksandr Sergijenko/Downloads/Table.xlsx
        //Aleksandr home
        //String excelFilePath = "C:/Users/aserg/Desktop/Logistics/Table.xlsx";
        //Grigorij
        //
        String excelFilePath = "C:/Users/aserg/Desktop/Logistics/Table.xlsx";
        List<Cargo> listBooks = reader.read(excelFilePath);
/*        for (Cargo cargo3 : listBooks) {
            System.out.println(cargo3);
        }*/
        Map<Integer, Integer[][]> containerList = new HashMap<>();

        Container container = new Container(TwentyFootContainer.LENGTH, TwentyFootContainer.WIDTH, 1);
        Integer[][] containerArray = containerCreationService.create(container.getContainerLength(), container.getContainerWidth());

        containerList.put(container.getContainerNumber(), containerArray);













        Cargo cargo = new Cargo(415,8, 10);
        addCargoToContainerService.addToContainer(1,1, containerArray, cargo);

        containerToConsoleViewService.printToConsole(containerList.get(1));


/*        //////////////создаем контейнер с тестовыми длинной и шириной
        Integer[][] createdContainer = containerCreationService.create(20, 10);
        Cargo cargo = new Cargo(415,8, 10);
        addCargoToContainerService.addToContainer(1,1,createdContainer, cargo);
        Cargo cargo2 = new Cargo(731,3, 3);
        Integer[] calculatedCoordinate = findSpaceForCargoService.coordinatesForCargo(createdContainer);
        addCargoToContainerService.addToContainer(calculatedCoordinate[0], calculatedCoordinate[1],createdContainer, cargo2);
        containerToConsoleViewService.printToConsole(createdContainer);



        //////////////print found dots
        ArrayList<Map<Integer, Integer>> foundCoordinates = findTemporaryCoordinatesService.findTemporaryCoordinates(createdContainer);
        for (int i = 0; i < foundCoordinates.toArray().length; i++) {
            Map<Integer, Integer> foundMapCoordinates = foundCoordinates.get(i);
            foundMapCoordinates.forEach((key, value) -> System.out.println(key + ":" + value));
        }



        System.out.println("sorted list");

        List<Cargo> sortedCargoList = listSortingService.sort(listBooks);
        for (Cargo cargo4 : sortedCargoList) {
            System.out.println(cargo4);
        }*/
    }
}