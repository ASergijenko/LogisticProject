package com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Point;
import com.logisticproject.services.ContainerCreationService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthCalculatorTest {

    private final ContainerCreationService containerCreationService = new ContainerCreationService();
    private final AddCargoToContainerService addCargoToContainerService = new AddCargoToContainerService();
    private final LengthCalculator victim = new LengthCalculator();

    @Test
    public void calculateLengthWithoutBorders() {
        Point TP_point = new Point(7, 2);
        Point TPNK_point = new Point(2, 2);
        Point boards = new Point(12, 12);
        Integer[][] array = containerCreationService.create(12, 10);

        assertEquals(new Point(4, 11), victim.calculateLength(array, TPNK_point, TP_point, boards));
    }

    @Test
    public void calculateLengthWithBorders() {
        Point TP_point = new Point(7, 2);
        Point TPNK_point = new Point(2, 2);
        Point boards = new Point(8, 9);
        Integer[][] array = containerCreationService.create(12, 10);

        assertEquals(new Point(3, 9), victim.calculateLength(array, TPNK_point, TP_point, boards));
    }

    @Test
    public void calculateLengthWithCargo() {
        Point TP_point = new Point(1, 1);
        Point TPNK_point = new Point(1, 1);
        Point boards = new Point(12, 12);
        Integer[][] array = containerCreationService.create(12, 10);
        addCargoToContainerService.addToContainer(new Point(3, 1), array, cargo());

        assertEquals(new Point(2, 12), victim.calculateLength(array, TPNK_point, TP_point, boards));
    }


    private Cargo cargo() {
        Cargo cargo = new Cargo();
        cargo.setCargoId(1);
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