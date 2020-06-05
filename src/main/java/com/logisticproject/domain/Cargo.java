package com.logisticproject.domain;

public class Cargo {

    private Integer cargoId;
    private Integer containerNumber;
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer weight;
    private boolean isStackable;
    private Integer quantity;
    private Integer totalWeight;
    private String comments;

    public Cargo() {
    }

    public Cargo(int cargoId, int containerNumber, int length, int width, int height, int weight, boolean isStackable, int quantity, int totalWeight, String comments) {
        this.cargoId = cargoId;
        this.containerNumber = containerNumber;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.isStackable = isStackable;
        this.quantity = quantity;
        this.totalWeight = totalWeight;
        this.comments = comments;
    }

    public Cargo(int cargoId, int length, int width) {
        this.cargoId = cargoId;
        this.length = length;
        this.width = width;
    }

    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    public Integer getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(Integer containerNumber) {
        this.containerNumber = containerNumber;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public boolean isStackable() {
        return isStackable;
    }

    public void setStackable(boolean stackable) {
        isStackable = stackable;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cargo cargo = (Cargo) o;

        if (cargoId != cargo.cargoId) return false;
        if (containerNumber != cargo.containerNumber) return false;
        if (length != cargo.length) return false;
        if (width != cargo.width) return false;
        if (height != cargo.height) return false;
        if (weight != cargo.weight) return false;
        if (isStackable != cargo.isStackable) return false;
        if (quantity != cargo.quantity) return false;
        if (totalWeight != cargo.totalWeight) return false;
        return comments != null ? comments.equals(cargo.comments) : cargo.comments == null;
    }

    @Override
    public int hashCode() {
        int result = cargoId;
        result = 31 * result + containerNumber;
        result = 31 * result + length;
        result = 31 * result + width;
        result = 31 * result + height;
        result = 31 * result + weight;
        result = 31 * result + (isStackable ? 1 : 0);
        result = 31 * result + quantity;
        result = 31 * result + totalWeight;
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "cargoId=" + cargoId +
                ", containerNumber=" + containerNumber +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", weight=" + weight +
                ", isStackable=" + isStackable +
                ", quantity=" + quantity +
                ", totalWeight=" + totalWeight +
                ", comments='" + comments + '\'' +
                '}';
    }



}