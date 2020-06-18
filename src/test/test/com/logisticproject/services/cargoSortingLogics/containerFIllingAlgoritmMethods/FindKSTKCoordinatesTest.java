package com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Point;
import com.logisticproject.services.ContainerCreationService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindKSTKCoordinatesTest {

    private final ContainerCreationService containerCreationService = new ContainerCreationService();
    private final AddCargoToContainerService addCargoToContainerService = new AddCargoToContainerService();
    private final FindKSTKCoordinates victim = new FindKSTKCoordinates();

    @Test
    public void findTemporaryCoordinatesCorrect() {
        Point TP_point = new Point(2,2);
        Integer[][] array = containerCreationService.create(12, 10);
        addCargoToContainerService.addToContainer(TP_point, array, cargo());

        List<Point> points = victim.findTemporaryCoordinates(TP_point, cargo());

        assertEquals(new Point(7,2), points.get(0));
        assertEquals(new Point(2,10), points.get(1));
        assertEquals(2, points.size());

/*        //Визуализация результата для каких либо нужд
        System.out.println(points.toString());
        array[2][7] = 5;
        array[10][2] = 5;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%5d ", array[i][j]);
            }
            System.out.println();
        }*/
    }

    private Cargo cargo() {
        Cargo cargo = new Cargo();
        cargo.setCargoId(1);
        cargo.setLength(8);
        cargo.setWidth(5);
        return cargo;
    }
}