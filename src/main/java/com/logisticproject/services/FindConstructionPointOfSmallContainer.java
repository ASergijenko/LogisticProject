package com.logisticproject.services;

import com.logisticproject.domain.ConstructionPoint;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindConstructionPointOfSmallContainer {

    public ConstructionPoint FindConstructionPointOfSmallContainer(List<ConstructionPoint> constructionPoints) {
        return Collections.max(constructionPoints, Comparator.comparing(constructionPoint -> constructionPoint.getyValue() * constructionPoint.getyValue()));
    }
}