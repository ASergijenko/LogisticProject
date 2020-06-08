package com.logisticproject.services;

import com.logisticproject.domain.Point;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindConstructionPointOfSmallContainer {

    public Point FindConstructionPointOfSmallContainer(List<Point> points) {
        return Collections.max(points, Comparator.comparing(constructionPoint -> constructionPoint.getValueY() * constructionPoint.getValueY()));
    }
}