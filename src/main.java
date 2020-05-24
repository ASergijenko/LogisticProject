import domain.Cargo;
import domain.ContainerTwentyFoot;
import services.AddCargoToContainerService;
import services.ContainerCreationService;
import services.ContainerToConsoleViewService;

public class main {
    public static void main(String[] args) {
        ContainerCreationService containerCreationService = new ContainerCreationService();
        ContainerToConsoleViewService containerToConsoleViewService = new ContainerToConsoleViewService();
        AddCargoToContainerService addCargoToContainerService = new AddCargoToContainerService();

        //int[][] createdContainer = containerCreationService.create(ContainerTwentyFoot.LENGTH, ContainerTwentyFoot.WIDTH);
        int[][] createdContainer = containerCreationService.create(20, 10);

        Cargo cargo = new Cargo(2,5, 5);
        addCargoToContainerService.addToContainer(0,0,createdContainer, cargo);
        Cargo cargo2 = new Cargo(8,3, 5);
        containerToConsoleViewService.printToConsole(addCargoToContainerService.addToContainer(6, 0,createdContainer, cargo2));
    }
}