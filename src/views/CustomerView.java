package views;

import java.util.Scanner;

public class CustomerView {
    Scanner sc = new Scanner(System.in);
    int choiceCustomer;
    public int customerView(){
        System.out.println("____________Khách hàng___________");
        System.out.println("1.Tìm kiếm thông tin vật nuôi");
        System.out.println("2.Hiển thị danh sách vật nuôi");
        System.out.println("3.Mua vật nuôi");
        System.out.println("4.Danh sách đã mua");
        System.out.print("Nhập lựa chọn: ");
        choiceCustomer = Integer.parseInt(sc.nextLine());
        return choiceCustomer;
    }
}
