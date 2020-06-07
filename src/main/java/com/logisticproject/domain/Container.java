package com.logisticproject.domain;

public class Container {

    private Integer containerLength;
    private Integer containerWidth;
    private Integer containerNumber;

    public Container(Integer containerLength, Integer containerWidth, Integer containerNumber) {
        this.containerLength = containerLength;
        this.containerWidth = containerWidth;
        this.containerNumber = containerNumber;
    }

    public Integer getContainerLength() {
        return containerLength;
    }

    public void setContainerLength(Integer containerLength) {
        this.containerLength = containerLength;
    }

    public Integer getContainerWidth() {
        return containerWidth;
    }

    public void setContainerWidth(Integer containerWidth) {
        this.containerWidth = containerWidth;
    }

    public Integer getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(Integer containerNumber) {
        this.containerNumber = containerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Container container = (Container) o;

        if (containerLength != null ? !containerLength.equals(container.containerLength) : container.containerLength != null)
            return false;
        if (containerWidth != null ? !containerWidth.equals(container.containerWidth) : container.containerWidth != null)
            return false;
        return containerNumber != null ? containerNumber.equals(container.containerNumber) : container.containerNumber == null;
    }

    @Override
    public int hashCode() {
        int result = containerLength != null ? containerLength.hashCode() : 0;
        result = 31 * result + (containerWidth != null ? containerWidth.hashCode() : 0);
        result = 31 * result + (containerNumber != null ? containerNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Container{" +
                "containerLength=" + containerLength +
                ", containerWidth=" + containerWidth +
                ", containerNumber=" + containerNumber +
                '}';
    }
}