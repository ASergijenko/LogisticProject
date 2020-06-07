package com.logisticproject.services;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.ConstructionPoint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FindTemporaryCoordinatesService {

    public List<ConstructionPoint> findTemporaryCoordinates(ConstructionPoint constructionPoint, Cargo createdCargo) {
        List<ConstructionPoint> constructionPoints = new ArrayList<>();
        ConstructionPoint newConstructionPoint;
        Integer xValue = 1;
        Integer yValue = 1;
        if (constructionPoint.getxValue().equals(xValue) && constructionPoint.getyValue().equals(yValue)) {
            newConstructionPoint = constructionPoint;
            constructionPoints.add(newConstructionPoint);
        } else {
            ConstructionPoint constructionPointInX = new ConstructionPoint(constructionPoint.getxValue() + createdCargo.getWidth(), constructionPoint.getyValue());
            ConstructionPoint constructionPointInY = new ConstructionPoint(constructionPoint.getxValue(), constructionPoint.getyValue() + createdCargo.getLength());
            if (constructionPointInX.getxValue() - constructionPoint.getxValue() < constructionPointInY.getyValue() - constructionPoint.getyValue()) {
                constructionPoints.add(0, constructionPointInX);
                constructionPoints.add(1, constructionPointInY);
            } else if (constructionPointInY.getyValue() - constructionPoint.getyValue() < constructionPointInX.getxValue() - constructionPoint.getxValue()) {
                constructionPoints.add(0, constructionPointInY);
                constructionPoints.add(1, constructionPointInX);
            } else {
                constructionPoints.add(0, constructionPointInX);
                constructionPoints.add(1, constructionPointInY);
            }
        }
    return constructionPoints;
    }
}