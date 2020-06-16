package com.logisticproject.services.cargoSortingLogics.cargoSortingMethods;

import com.logisticproject.domain.Cargo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExistsNotUsedCargoTest {

    private final ExistsNotUsedCargo victim = new ExistsNotUsedCargo();

    @Test
    public void checkTrue() {
        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(cargoGood());
        cargoList.add(cargoBad());

        assertTrue(victim.check(cargoList));
    }

    @Test
    public void checkFalse() {
        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(cargoBad());

        assertFalse(victim.check(cargoList));
    }


    private Cargo cargoGood() {
        Cargo cargo = new Cargo();
        return cargo;
    }

    private Cargo cargoBad() {
        Cargo cargo = new Cargo();
        cargo.setContainerNumber(1);
        return cargo;
    }
}