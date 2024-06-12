package views;

import models.manager.Animal;
import models.manager.Chicken;
import models.manager.Pig;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ManagerView {

    public int viewMenu() {
        System.out.println("____________Quản lí_____________");
        System.out.println("1.Thêm mới");
        System.out.println("2.Sửa thông tin");
        System.out.println("3.Xóa");
        System.out.println("4.Hiển thị danh sách         ");
        System.out.println("5.Tìm kiếm                   ");
        System.out.println("6.Danh sách đã bán           ");
        System.out.println("7.Quay về trang chủ         ");
        System.out.println("_______________________________");
        System.out.print("Nhập lựa chọn :");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = Integer.parseInt(sc.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một số");
        }
        return -1;

    }


    public Chicken viewAddChicken() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã:");
            String code = "GA" + sc.nextLine();
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
        } catch (NumberFormatException e) {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một số");
        } catch (Exception e) {
            System.out.println("Lỗi" + e.getMessage());
        }
        return null;
    }

    public void viewMessage(boolean result) {
        if (result) {
            System.out.println("Tác vụ thành công!");
        } else {
            System.out.println("Tác vụ thất bại!");
        }
    }

    public String findByCode() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã:");
            String code = sc.nextLine();
            return code;
        } catch (InputMismatchException e) {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một số.");
        }
        return null;

    }

    public String findByName() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên:");
        String name = sc.nextLine();
        return name;
    }

    public boolean viewConfirmDelete(Animal animalByCode) {

            System.out.println("Bạn có muốn xóa hay không?");
            System.out.println(animalByCode);
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
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập tên:");
            String name = sc.nextLine();
            System.out.print("Nhập giá:");
            double price = Double.parseDouble(sc.nextLine());
            System.out.print("Nhập số lượng:");
            int quantity = Integer.parseInt(sc.nextLine());
            if (choiceAnimal == 1) {
                if (animal instanceof Chicken) {
                    Chicken chicken = (Chicken) animal;
                    System.out.print("Nhập xuất xứ: ");
                    String origin = sc.nextLine();
                    chicken.setOrigin(origin);
                }
            }
            if (choiceAnimal == 2) {
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
        }catch (NumberFormatException e){
            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một số");
        }catch(Exception e){
            System.out.println("Lỗi định dạng"+ e.getMessage());
        }

    }


    public int choiceAnimal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Chọn gà");
        System.out.println("2.Chọn lợn");
        System.out.print("Nhập lựa chọn: ");
        try {
            int choiceAnimal = sc.nextInt();
            return choiceAnimal;
        }catch (InputMismatchException e) {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một số.");
        }
        return -1;
    }

    public Pig viewAddPig() {
       try{
           Scanner sc = new Scanner(System.in);
           System.out.print("Nhập mã:");
           String code = "HEO" + sc.nextLine();
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
       }catch (NumberFormatException e){
           System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một số");
       }catch (Exception e){
           System.out.println("Lỗi định dạng!");
       }
       return null;
    }

    public void viewAll(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            System.out.println("Danh sách rỗng!");
        } else {
            for (Animal animal : animalList) {
                System.out.println(animal);
            }
        }

    }

    public void DisplayFind(Animal animalByCode, Animal animalByName) {
        System.out.println("Danh sách tìm thấy:");
        if (animalByCode == null && animalByName == null) {
            System.out.println("Không tìm thấy!");
        }
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

