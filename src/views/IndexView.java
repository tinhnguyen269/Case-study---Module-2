package views;

import java.util.Scanner;

public class IndexView {
    public int indexView(){
        Scanner sc = new Scanner(System.in);
        System.out.println("________________Trang trại______________");
        System.out.println("1.Quản lí");
        System.out.println("2.Khách hàng");
        System.out.print("Nhập lựa chọn:");
        try{
            int choiceIndex = Integer.parseInt(sc.nextLine());
            return choiceIndex;
        }catch (NumberFormatException e){
            System.out.println("Nhap vao so");
        }
        return -1;

    }
}
