package com.logisticproject.services.cargoSortingLogics.containerFIllingAlgoritmMethods;

import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RemovePointFromRepository {
    public List<Point> removePointFromRepository(Point TP_point, List<Point> repository) {
        repository.removeIf(point -> point.equals(TP_point));
        return repository;
    }
}