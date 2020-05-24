package domain;

public class Cargo {

    private int cargoId;
    private int containerNumber;
    private int length;
    private int width;
    private int height;
    private int weight;
    private boolean isStackable;
    private int quantity;
    private int totalWeight;
    private String comments;

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

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public int getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(int containerNumber) {
        this.containerNumber = containerNumber;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isStackable() {
        return isStackable;
    }

    public void setStackable(boolean stackable) {
        isStackable = stackable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
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
}