package views;

import models.manager.Animal;
import models.manager.Chicken;
import models.manager.Pig;

import java.util.List;
import java.util.Scanner;

public class ManagerView {

    public int viewMenu() {
        System.out.println("____________Quản lí___________");
        System.out.println("1.Thêm mới");
        System.out.println("2.Sửa thông tin");
        System.out.println("3.Xóa ");
        System.out.println("4.Hiển thị danh sách");
        System.out.println("5.Tìm kiếm");
        System.out.println("6.Danh sách đã bán");
        System.out.println("7.Quay về trang chủ");
        System.out.print("Nhập lựa chọn :");
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }


    public Chicken viewAddChicken() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã:");
        String code = sc.nextLine();
        System.out.print("Nhập tên:");
        String name = sc.nextLine();
        System.out.print("Nhập giá:");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng:");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập Xuất xứ:");
        String origin = sc.nextLine();
        Chicken animal = new Chicken(code, name, price, quantity, origin);
        return animal;
    }

    public void viewMessage(boolean result) {
        if (result) {
            System.out.println("Tác vụ thành công!");
        } else {
            System.out.println("Tác vụ thất bại!");
        }
    }


    public void viewALL(Chicken[] chickens, Pig[] pigs) {
        System.out.println("Danh sách vật nuôi trong trang trại:");
        System.out.println("...............Gà..............");
        for (Chicken chicken : chickens) {
            System.out.println(inforChicken(chicken));
        }
        System.out.println("...............Lợn..............");
        for (Pig pig : pigs) {
            System.out.println(inforPig(pig));
        }
    }

    private String inforChicken(Chicken chicken) {
        return "Mã:" + chicken.getCode() + " ,Tên:" + chicken.getName() + " ,Giá:" + chicken.getPrice() + " ,số lượng:" + chicken.getQuantity() + " ,Xuất xứ:" + chicken.getOrigin();
    }

    private String inforPig(Pig pig) {
        return "Mã:" + pig.getCode() + " ,Tên:" + pig.getName() + " ,Giá:" + pig.getPrice() + " ,số lượng:" + pig.getQuantity() + " ,Cân nặng:" + pig.getWeight();
    }


    public String findByCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã:");
        String code = sc.nextLine();
        return code;
    }

    public String findByName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên:");
        String name = sc.nextLine();
        return name;
    }

    public boolean viewConfirmDelete() {
        System.out.println("Bạn có muốn xóa hay không?");
        System.out.print("Bấm Y để xác nhận,N để hủy:");
        Scanner sc = new Scanner(System.in);
        String confirm = sc.nextLine();
        if (confirm.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public void updateAnimal(int choiceAnimal, Animal animal) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên:");
        String name = sc.nextLine();
        System.out.print("Nhập giá:");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng:");
        int quantity = Integer.parseInt(sc.nextLine());
        if(choiceAnimal==1){
            if (animal instanceof Chicken) {
                Chicken chicken = (Chicken) animal;
                System.out.print("Nhập xuất xứ: ");
                String origin = sc.nextLine();
                chicken.setOrigin(origin);
           }
        }
        if(choiceAnimal==2){
            if (animal instanceof Pig) {
                Pig pig = (Pig) animal;
                System.out.print("Nhập cân nặng: ");
                double weight = Double.parseDouble(sc.nextLine());
                ((Pig) animal).setWeight(weight);
            }
        }
        animal.setName(name);
        animal.setPrice(price);
        animal.setQuantity(quantity);
    }


    public int choiceAnimal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Chọn gà");
        System.out.println("2.Chọn lợn");
        System.out.print("Nhập lựa chọn: ");
        int choiceAnimal = sc.nextInt();
        return choiceAnimal;

    }

    public Pig viewAddPig() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã:");
        String code = sc.nextLine();
        System.out.print("Nhập tên:");
        String name = sc.nextLine();
        System.out.print("Nhập giá:");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng:");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập cân nặng:");
        double weight = sc.nextDouble();
        Pig animal = new Pig(code, name, price, quantity, weight);
        return animal;
    }

    public void viewAll(List<Animal> animalList) {
        for (Animal animal : animalList) {
            System.out.println(animal);

        }
    }

    public void DisplayFind(Animal animalByCode, Animal animalByName) {
        System.out.println("Danh sách tìm thấy:");
        if (animalByCode == null) {
            System.out.print("");
        } else {
            System.out.println(animalByCode);
        }
        if (animalByName == null) {
            System.out.println("");
        } else {
            System.out.println(animalByName);
        }
    }
}

