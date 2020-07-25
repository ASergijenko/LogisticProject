package com.cargoproject.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.cargoproject.logisticproject.domain.Cargo;
import com.cargoproject.logisticproject.domain.Point;
import com.cargoproject.logisticproject.services.cargoSortingLogics.cargoSortingMethods.ContainerCreationService;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AddCargoToContainerServiceTest {

    private final AddCargoToContainerService victim = new AddCargoToContainerService();
    private final ContainerCreationService containerCreationService = new ContainerCreationService();

    @Test
    public void addToContainer() {
        Point point = new Point(2, 2);
        Double[][] array = containerCreationService.create(10, 10);

        victim.addToContainer(point, array, cargo());

        assertTrue(checkOfFilledZone(point,array));
    }

    private boolean checkOfFilledZone(Point point, Double[][] array) {
        for (Integer i = point.getValueY(); i < point.getValueY() + cargo().getLength(); i++) {
            for (Integer j = point.getValueX(); j < point.getValueX() + cargo().getWidth(); j++) {
                if (array[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private Cargo cargo() {
        Cargo cargo = new Cargo();
        cargo.setCargoId((double)1);
        cargo.setLength(8);
        cargo.setWidth(5);
        return cargo;
    }

    /*        //Визуализация результата для каких либо нужд
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%5d ", array[i][j]);
            }
            System.out.println();
        }*/
}