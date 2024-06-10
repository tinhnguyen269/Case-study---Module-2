package models.manager;

public class Chicken extends Animal {
    private String origin;


    public Chicken(String code, String name, double price, int quantity, String origin) {
        super(code, name, price, quantity);
        this.origin = origin;
    }

    public Chicken() {
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }


    public String toString() {
        return "(Chicken) " +
                "Mã: " + this.getCode()+
                ", Tên: " + this.getName() +
                ", Giá: " + this.getPrice() +
                ", Số lượng:" + this.getQuantity() +
                ", Xuất xứ: " + this.getOrigin() ;
    }

}

