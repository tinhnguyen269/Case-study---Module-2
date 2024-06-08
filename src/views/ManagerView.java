package views;

import models.manager.Chicken;
import models.manager.Pig;

import java.util.Scanner;

public class ManagerView {
    Chicken chicken = new Chicken();
    LoginView loginView = new LoginView();

    public int view() {
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
        Chicken chicken = new Chicken(code, name, price, quantity, origin);
        return chicken;
    }

    public void viewMessage(boolean result) {
        if (result) {
            System.out.println("Tác vụ thành công!");
        } else {
            System.out.println("Tác vụ thất bại!");
        }
    }

    public void viewALL(Chicken[] chickens) {
        System.out.println("Danh sách gà trong trang trại:");
        for (Chicken chicken : chickens) {
            System.out.println(inforChicken(chicken));
        }
    }

    private String inforChicken(Chicken chicken) {
        return "Mã:" + chicken.getCode() + " ,Tên:" + chicken.getName() + " ,Giá:" + chicken.getPrice() + " ,số lượng:" + chicken.getQuantity() + " ,Xuất xứ:" + chicken.getOrigin();
    }

    public String findByCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã gà:");
        String code = sc.nextLine();
        return code;
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

    public Chicken updateChicken(Chicken chicken) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên:");
        String name = sc.nextLine();
        System.out.print("Nhập giá:");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng:");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập Xuất xứ:");
        String origin = sc.nextLine();
        chicken.setName(name);
        chicken.setPrice(price);
        chicken.setQuantity(quantity);
        chicken.setOrigin(origin);
        return chicken;

    }


    public String findAnimal() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào mã,tên: ");
        String find = sc.nextLine();
        return find;
    }

    public int choiceAnimal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập lựa chọn: ");
        System.out.println("1.Thêm gà");
        System.out.println("2.Thêm lơn");
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
        double weight  = sc.nextDouble();
        Pig pig = new Pig(code,name,price,quantity,weight);
        return pig;
    }
}


