package com.logisticproject.services.cargoSortingLogics.cargoSortingMethods;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Container;
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
        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(cargoGood());
        cargoList.add(cargoBad());

        assertTrue(victim.isSuitableCargo(cargoList, container));
    }

    @Test
    public void isSuitableCargoFalse() {
        Container container = new Container(10, 5, 1);
        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(cargoBad());

        assertFalse(victim.isSuitableCargo(cargoList, container));
    }

    private Cargo cargoGood() {
        Cargo cargo = new Cargo();
        cargo.setLength(10);
        cargo.setWidth(5);
        cargo.setSquare(5 * 10);
        return cargo;
    }

    private Cargo cargoBad() {
        Cargo cargo = new Cargo();
        cargo.setLength(11);
        cargo.setWidth(6);
        cargo.setSquare(11 * 6);
        return cargo;
    }
}