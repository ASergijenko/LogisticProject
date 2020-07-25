package com.cargoproject.logisticproject.services.cargoSortingLogics.cargoSortingMethods;

import com.cargoproject.logisticproject.domain.Cargo;
import com.cargoproject.logisticproject.domain.Container;
import com.cargoproject.logisticproject.domain.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContainerFullnessCheckTest {

    private final ContainerFullnessCheck victim = new ContainerFullnessCheck();

    @Test
    public void isSuitableCargoTrue() {
        Container container = new Container(10, 5, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1, 1));
        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(cargoGood());
        cargoList.add(cargoBad());

        assertTrue(victim.isSuitableCargo(cargoList, container, pointList));
    }

    @Test
    public void isSuitableCargoFalseBothSides() {
        Container container = new Container(10, 5, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1, 1));
        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(cargoBad());

        assertFalse(victim.isSuitableCargo(cargoList, container, pointList));
    }

    @Test
    public void isSuitableCargoFalseContainerNumber() {
        Container container = new Container(10, 5, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1, 1));
        List<Cargo> cargoList = new ArrayList<>();
        Cargo cargo = cargoGood();
        cargo.setContainerNumber(1);
        cargoList.add(cargo);

        assertFalse(victim.isSuitableCargo(cargoList, container, pointList));
    }

    @Test
    public void isSuitableCargoPointListEmpty() {
        Container container = new Container(10, 5, 1);
        List<Point> pointList = new ArrayList<>();
        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(cargoBad());

        assertFalse(victim.isSuitableCargo(cargoList, container, pointList));
    }

    private Cargo cargoGood() {
        Cargo cargo = new Cargo();
        cargo.setLength(10);
        cargo.setWidth(5);
        cargo.setSquare();
        return cargo;
    }

    private Cargo cargoBad() {
        Cargo cargo = new Cargo();
        cargo.setLength(11);
        cargo.setWidth(6);
        cargo.setSquare();
        return cargo;
    }
}
