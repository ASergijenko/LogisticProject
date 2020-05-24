import domain.Cargo;
import domain.ContainerTwentyFoot;
import services.AddCargoToContainerService;
import services.ContainerCreationService;
import services.ContainerToConsoleViewService;
import services.FindFreeCoordinatesForNowService;

import java.util.Map;

public class main {
    public static void main(String[] args) {
        ContainerCreationService containerCreationService = new ContainerCreationService();
        ContainerToConsoleViewService containerToConsoleViewService = new ContainerToConsoleViewService();
        AddCargoToContainerService addCargoToContainerService = new AddCargoToContainerService();
        FindFreeCoordinatesForNowService findFreeCoordinatesForNowService = new FindFreeCoordinatesForNowService();

        //int[][] createdContainer = containerCreationService.create(ContainerTwentyFoot.LENGTH, ContainerTwentyFoot.WIDTH);
        int[][] createdContainer = containerCreationService.create(20, 10);

        Cargo cargo = new Cargo(4,5, 5);
        addCargoToContainerService.addToContainer(1,1,createdContainer, cargo);
        Cargo cargo2 = new Cargo(7,3, 3);
        addCargoToContainerService.addToContainer(6, 1,createdContainer, cargo2);
        containerToConsoleViewService.printToConsole(createdContainer);

        Map<Integer, Integer> foundCoordinates = findFreeCoordinatesForNowService.findCoordinates(createdContainer);

        foundCoordinates.forEach((key, value) -> System.out.println(key + " " + value));

    }
}

/*
//координаты 0 по х
0 по у от 0,0
добавляются в коллекцию


при добавлении
точка удаляется

*/


