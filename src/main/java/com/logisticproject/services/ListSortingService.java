package com.logisticproject.services;

import com.logisticproject.domain.Cargo;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListSortingService {

    public List<Cargo> sort(List<Cargo> cargoList) {
        //swap
        for (Cargo cargo : cargoList) {
            int temp = 0;
            if (cargo.getLength() < cargo.getWidth()) {
                temp = cargo.getWidth();
                cargo.setWidth(cargo.getLength());
                cargo.setLength(temp);
            }
        }
        return cargoList.stream().sorted(Comparator.comparingInt(Cargo::getLength).reversed()).collect(Collectors.toList());
    }
}