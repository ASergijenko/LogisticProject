package com.logisticproject;

import com.logisticproject.domain.Cargo;
import com.logisticproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class LogisticExecute {

    @Autowired private ContainerCreationService containerCreationService;
    @Autowired private ContainerToConsoleViewService containerToConsoleViewService;
    @Autowired private AddCargoToContainerService addCargoToContainerService;
    @Autowired private FindTemporaryCoordinatesService findTemporaryCoordinatesService;
    @Autowired private FindSpaceForCargoService findSpaceForCargoService;
    @Autowired private ExcelParsingService reader;
    @Autowired private ListSortingService listSortingService;

    public void execute() throws Exception {
        /////////////////////////////////Modify SPRING


        //////////////cargo tests
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

        //////////print parsed data from collection
        //Aleksandr work
        //C:/Users/Aleksandr Sergijenko/Downloads/Table.xlsx
        //Aleksandr home
        //String excelFilePath = "C:/Users/aserg/Desktop/Logistics/Table.xlsx";
        //Grigorij
        //


        String excelFilePath = "C:/Users/aserg/Desktop/Logistics/Table.xlsx";
        List<Cargo> listBooks = reader.getCargoList(excelFilePath);
        for (Cargo cargo3 : listBooks) {
            System.out.println(cargo3);
        }

        System.out.println("sorted list");

        List<Cargo> sortedCargoList = listSortingService.sort(listBooks);
        for (Cargo cargo4 : sortedCargoList) {
            System.out.println(cargo4);
        }
    }
}