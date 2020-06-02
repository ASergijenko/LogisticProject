package com.logisticproject.services;

import com.logisticproject.domain.Cargo;

import java.util.List;

public class ListSortingService {

    public List<Cargo> sort(List<Cargo> cargoList) {
        for (Cargo cargo : cargoList) {
            int xTemp = 0;
            int yTemp = 0;
            if (cargo.getLength() > cargo.getWidth()) {

            } else if (cargo.getLength() < cargo.getWidth()) {

            } else {
                continue;
            }
        }
    }
}