package com.logisticproject.services;

import com.logisticproject.domain.ConstructionPoint;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemporaryCoordinateHandlingService {

    public List<ConstructionPoint> handleCoordinates(List<ConstructionPoint> temporaryConstructionPoints, List<ConstructionPoint> pointsRepository) {
        pointsRepository.add(temporaryConstructionPoints.get(1));
        return pointsRepository;
    }
}
