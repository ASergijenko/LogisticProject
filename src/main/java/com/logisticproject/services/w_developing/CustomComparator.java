package com.logisticproject.services.w_developing;

import com.logisticproject.domain.Point;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class CustomComparator implements Comparator<Point> {

    @Override
    public int compare(Point point, Point t1) {
        return point.getValueY().compareTo(t1.getValueY());
    }
}

