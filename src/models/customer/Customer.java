package models.customer;

public class Customer {
    private String name;
    private int phone;

    public Customer(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Khách hàng:" +
                 name + " "+
                 phone
                ;
    }
}
