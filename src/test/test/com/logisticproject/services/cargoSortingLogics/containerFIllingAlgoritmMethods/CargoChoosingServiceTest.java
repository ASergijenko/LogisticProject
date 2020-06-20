package com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CargoChoosingServiceTest {

    private final CargoChoosingService victim = new CargoChoosingService();

    @Test
    public void chooseCargoTrue() {
        Point length = new Point(10, 10);
        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(cargo());

        assertEquals(cargo(), victim.chooseCargo(cargoList, length));
    }

    @Test
    public void chooseCargoFalseLength() {
        Point length = new Point(10, 7);
        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(cargo());

        assertNull(victim.chooseCargo(cargoList, length));
    }

    @Test
    public void chooseCargoFalseWidth() {
        Point length = new Point(4, 10);
        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(cargo());

        assertNull(victim.chooseCargo(cargoList, length));
    }

    @Test
    public void chooseCargoFalseCargoList() {
        Point length = new Point(10, 10);
        List<Cargo> cargoList = new ArrayList<>();
        Cargo cargo = new Cargo();
        cargo.setContainerNumber(1);
        cargoList.add(cargo);

        assertNull(victim.chooseCargo(cargoList, length));
    }

    private Cargo cargo() {
        Cargo cargo = new Cargo();
        cargo.setCargoId(1);
        cargo.setLength(8);
        cargo.setWidth(5);
        return cargo;
    }
}
