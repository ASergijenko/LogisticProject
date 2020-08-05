/*
package com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.logisticproject.constants.TwentyFootContainer;
import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Point;
import com.logisticproject.services.cargoSortingLogics.cargoSortingMethods.ContainerCreationService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FindKSTKCoordinatesTest {

    private final ContainerCreationService containerCreationService = new ContainerCreationService();
    private final AddCargoToContainerService addCargoToContainerService = new AddCargoToContainerService();
    private final FindKSTKCoordinates victim = new FindKSTKCoordinates();

    @Test
    public void findTemporaryCoordinatesCorrect() {
        Point TP_point = new Point(2, 2);
        Double[][] array = containerCreationService.create(12, 10);
        addCargoToContainerService.addToContainer(TP_point, array, cargo());

        List<Point> points = victim.findTemporaryCoordinates(TP_point, cargo());

        assertEquals(new Point(7, 2), points.get(0));
        assertEquals(new Point(2, 10), points.get(1));
        assertEquals(2, points.size());
    }

    @Test
    public void findTemporaryCoordinatesContainerBordersFalse() {
        Point TP_point = new Point(TwentyFootContainer.WIDTH - 4, TwentyFootContainer.LENGTH - 7);
        Integer[][] array = containerCreationService.create(TwentyFootContainer.LENGTH, TwentyFootContainer.WIDTH);
        addCargoToContainerService.addToContainer(TP_point, array, cargo());
        List<Point> points = victim.findTemporaryCoordinates(TP_point, cargo());

        assertTrue(points.isEmpty());
    }

    @Test
    public void findTemporaryCoordinatesContainerXBorderFalse() {
        Point TP_point = new Point(TwentyFootContainer.WIDTH - 4, TwentyFootContainer.LENGTH - 10);
        Integer[][] array = containerCreationService.create(TwentyFootContainer.LENGTH, TwentyFootContainer.WIDTH);
        addCargoToContainerService.addToContainer(TP_point, array, cargo());
        List<Point> points = victim.findTemporaryCoordinates(TP_point, cargo());

        assertEquals(new Point(16, 48), points.get(0));
        assertEquals(1, points.size());
    }

    @Test
    public void findTemporaryCoordinatesContainerYBorderFalse() {
        Point TP_point = new Point(TwentyFootContainer.WIDTH - 4, TwentyFootContainer.LENGTH - 8);
        Integer[][] array = containerCreationService.create(TwentyFootContainer.LENGTH, TwentyFootContainer.WIDTH);
        addCargoToContainerService.addToContainer(TP_point, array, cargo());
        List<Point> points = victim.findTemporaryCoordinates(TP_point, cargo());

        assertEquals(new Point(16, 50), points.get(0));
        assertEquals(1, points.size());
    }

    private Cargo cargo() {
        Cargo cargo = new Cargo();
        cargo.setCargoId(1);
        cargo.setLength(8);
        cargo.setWidth(5);
        return cargo;
    }

    */
/*        //Визуализация результата для каких либо нужд
        System.out.println(points.toString());
        array[2][7] = 5;
        array[10][2] = 5;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%5d ", array[i][j]);
            }
            System.out.println();
        }*//*


    private Cargo cargo() {
        Cargo cargo = new Cargo();
        cargo.setCargoId((double)1);
        cargo.setLength(8);
        cargo.setWidth(5);
        return cargo;
    }
}*/
