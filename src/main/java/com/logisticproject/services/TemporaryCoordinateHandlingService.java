package com.logisticproject.services;

import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemporaryCoordinateHandlingService {
    public List<Point> handleCoordinates(List<Point> temporaryPoints, List<Point> pointsRepository) {
        pointsRepository.add(temporaryPoints.get(1));
        return pointsRepository;
    }
}
