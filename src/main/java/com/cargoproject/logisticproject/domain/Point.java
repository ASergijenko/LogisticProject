package com.cargoproject.logisticproject.domain;

import java.util.Objects;

public class Point {
    private Integer xValue;
    private Integer yValue;

    public Point() {
    }

    public Point(Integer xValue, Integer yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public Integer getValueX() {
        return xValue;
    }

    public void setxValue(Integer xValue) {
        this.xValue = xValue;
    }

    public Integer getValueY() {
        return yValue;
    }

    public void setyValue(Integer yValue) {
        this.yValue = yValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point that = (Point) o;
        return Objects.equals(xValue, that.xValue) &&
                Objects.equals(yValue, that.yValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xValue, yValue);
    }

    @Override
    public String toString() {
        return "{axisX=" + xValue +
                ", axisY=" + yValue +
                '}';
    }
}
