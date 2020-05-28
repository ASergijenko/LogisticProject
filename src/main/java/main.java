import domain.Cargo;
import services.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) throws IOException {
        /////////////////////////////////ADD SPRING
        ContainerCreationService containerCreationService = new ContainerCreationService();
        ContainerToConsoleViewService containerToConsoleViewService = new ContainerToConsoleViewService();
        AddCargoToContainerService addCargoToContainerService = new AddCargoToContainerService();
        FindFreeCoordinatesForNowService findFreeCoordinatesForNowService = new FindFreeCoordinatesForNowService();
        FindSpaceForCargoService findSpaceForCargoService = new FindSpaceForCargoService();


        Integer[][] createdContainer = containerCreationService.create(20, 10);

        Cargo cargo = new Cargo(415,8, 10);
        addCargoToContainerService.addToContainer(1,1,createdContainer, cargo);

        Cargo cargo2 = new Cargo(731,3, 3);
        Integer[] calculatedCoordinate = findSpaceForCargoService.coordinatesForCargo(createdContainer);

        addCargoToContainerService.addToContainer(calculatedCoordinate[0], calculatedCoordinate[1],createdContainer, cargo2);

        containerToConsoleViewService.printToConsole(createdContainer);

        ArrayList<Map<Integer, Integer>> foundCoordinates = findFreeCoordinatesForNowService.findCoordinates(createdContainer);
        for (int i = 0; i < foundCoordinates.toArray().length; i++) {
            Map<Integer, Integer> foundMapCoordinates = foundCoordinates.get(i);
            foundMapCoordinates.forEach((key, value) -> System.out.println(key + ":" + value));
        }

        String excelFilePath = "C:/Users/aserg/Desktop/Logistics/Table.xlsx";
        ExcelParsingService reader = new ExcelParsingService();
        List<Cargo> listBooks = reader.getCargoList(excelFilePath);
        System.out.println(listBooks);


    }
}

/*test cases*/
/*        ArrayList<Map<Integer, Integer>> foundCoordinates = findFreeCoordinatesForNowService.findCoordinates(createdContainer);
        for (int i = 0; i < foundCoordinates.toArray().length; i++) {
            Map<Integer, Integer> foundMapCoordinates = foundCoordinates.get(i);
            foundMapCoordinates.forEach((key, value) -> System.out.println(key + ":" + value));
        }*/


