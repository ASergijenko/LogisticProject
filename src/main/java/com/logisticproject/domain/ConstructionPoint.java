package com.logisticproject.domain;

import java.util.Objects;

public class ConstructionPoint {
    private Integer xValue;
    private Integer yValue;

    public ConstructionPoint() {
    }

    public ConstructionPoint(Integer xValue, Integer yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public Integer getxValue() {
        return xValue;
    }

    public void setxValue(Integer xValue) {
        this.xValue = xValue;
    }

    public Integer getyValue() {
        return yValue;
    }

    public void setyValue(Integer yValue) {
        this.yValue = yValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstructionPoint that = (ConstructionPoint) o;
        return Objects.equals(xValue, that.xValue) &&
                Objects.equals(yValue, that.yValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xValue, yValue);
    }

    @Override
    public String toString() {
        return "ConstructionPoint{" +
                "xValue=" + xValue +
                ", yValue=" + yValue +
                '}';
    }
}
