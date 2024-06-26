package models.manager;

public class Pig extends Animal{
    private double weight;

    public Pig() {
    }

    public Pig(String code, String name, double price, int quantity, double weight) {
        super(code, name, price, quantity);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String toString() {
        return "(Pig) " +
                "Mã: " + this.getCode()+
                ", Tên: " + this.getName() +
                ", Giá: " + this.getPrice() +
                ", Số lượng: " + this.getQuantity() +
                ", Cân nặng: " + this.getWeight() ;
    }
}
