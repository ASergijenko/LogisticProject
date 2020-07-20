/*package com.logisticproject.domain;

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
    private Integer square;

    public Cargo() {
    }

    public Cargo(Integer cargoId, Integer containerNumber, Integer length, Integer width, Integer height, Integer weight, boolean isStackable, Integer quantity, Integer totalWeight, String comments) {
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
        this.square = length * width;
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

    public Integer getSquare() {
        return square;
    }

    public void setSquare(Integer square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cargo cargo = (Cargo) o;

        if (isStackable != cargo.isStackable) return false;
        if (cargoId != null ? !cargoId.equals(cargo.cargoId) : cargo.cargoId != null) return false;
        if (containerNumber != null ? !containerNumber.equals(cargo.containerNumber) : cargo.containerNumber != null)
            return false;
        if (length != null ? !length.equals(cargo.length) : cargo.length != null) return false;
        if (width != null ? !width.equals(cargo.width) : cargo.width != null) return false;
        if (height != null ? !height.equals(cargo.height) : cargo.height != null) return false;
        if (weight != null ? !weight.equals(cargo.weight) : cargo.weight != null) return false;
        if (quantity != null ? !quantity.equals(cargo.quantity) : cargo.quantity != null) return false;
        if (totalWeight != null ? !totalWeight.equals(cargo.totalWeight) : cargo.totalWeight != null) return false;
        if (comments != null ? !comments.equals(cargo.comments) : cargo.comments != null) return false;
        return square != null ? square.equals(cargo.square) : cargo.square == null;
    }

    @Override
    public int hashCode() {
        int result = cargoId != null ? cargoId.hashCode() : 0;
        result = 31 * result + (containerNumber != null ? containerNumber.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (isStackable ? 1 : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (totalWeight != null ? totalWeight.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (square != null ? square.hashCode() : 0);
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
                ", square=" + square +
                '}';
    }
}*/


package com.logisticproject.domain;

public class Cargo implements Cloneable{

    private Double cargoId;
    private Integer containerNumber;
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer weight;
    private boolean isStackable;
    private Integer quantity;
    private Integer totalWeight;
    private String comments;
    private Integer square;

    public Cargo() {
    }

    public Cargo(Double cargoId, Integer containerNumber, Integer length, Integer width, Integer height, Integer weight, boolean isStackable, Integer quantity, Integer totalWeight, String comments, Integer square) {
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
        this.square = square;
    }

    public Double getCargoId() {
        return cargoId;
    }

    public void setCargoId(Double cargoId) {
        this.cargoId = cargoId;
    }

    public void setSquare(Integer square) {
        this.square = square;
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

    public Integer getSquare() {
        return square;
    }

//    public void setSquares(Integer square) {
//        this.square = square;
//    }

    public void setSquare() {
        this.square = this.length * this.width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cargo cargo = (Cargo) o;

        if (isStackable != cargo.isStackable) return false;
        if (cargoId != null ? !cargoId.equals(cargo.cargoId) : cargo.cargoId != null) return false;
        if (containerNumber != null ? !containerNumber.equals(cargo.containerNumber) : cargo.containerNumber != null)
            return false;
        if (length != null ? !length.equals(cargo.length) : cargo.length != null) return false;
        if (width != null ? !width.equals(cargo.width) : cargo.width != null) return false;
        if (height != null ? !height.equals(cargo.height) : cargo.height != null) return false;
        if (weight != null ? !weight.equals(cargo.weight) : cargo.weight != null) return false;
        if (quantity != null ? !quantity.equals(cargo.quantity) : cargo.quantity != null) return false;
        if (totalWeight != null ? !totalWeight.equals(cargo.totalWeight) : cargo.totalWeight != null) return false;
        if (comments != null ? !comments.equals(cargo.comments) : cargo.comments != null) return false;
        return square != null ? square.equals(cargo.square) : cargo.square == null;
    }

    @Override
    public int hashCode() {
        int result = cargoId != null ? cargoId.hashCode() : 0;
        result = 31 * result + (containerNumber != null ? containerNumber.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (isStackable ? 1 : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (totalWeight != null ? totalWeight.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (square != null ? square.hashCode() : 0);
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
                ", square=" + square +
                '}';
    }

    @Override
    public Cargo clone() throws CloneNotSupportedException {
        return (Cargo) super.clone();
    }
}