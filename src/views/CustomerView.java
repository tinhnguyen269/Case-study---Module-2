package views;

import models.manager.Animal;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerView {

    Scanner sc = new Scanner(System.in);
    int choiceCustomer;

    public static boolean viewConfirmBuy(Animal animalByCode) {

        try {
            System.out.println("Bạn có muốn mua :" + animalByCode + " hay không?");
            System.out.print("Bấm Y để xác nhận,N để hủy:");
            Scanner sc = new Scanner(System.in);
            String confirm = sc.nextLine();
            if (confirm.equals("Y")) {
                return true;
            } else if (confirm.equals("N")) {
                return false;
            } else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng bấm Y hoặc N.");
                return false;
            }
        } catch (InputMismatchException e) {
            System.out.println("Nhập không hợp lệ. Vui lòng bấm Y hoặc N.");
            return false;
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            return false;
        }
    }

        public int customerViewMenu () {
            System.out.println("____________Khách hàng___________");
            System.out.println("1.Tìm kiếm thông tin vật nuôi");
            System.out.println("2.Hiển thị danh sách vật nuôi");
            System.out.println("3.Mua vật nuôi");
            System.out.println("4.Danh sách đã mua");
            System.out.println("5.Quay về trang chủ");
            System.out.println("_________________________________");
            System.out.print("Nhập lựa chọn: ");
            try {
                Scanner sc = new Scanner(System.in);
                choiceCustomer = sc.nextInt();
                return choiceCustomer;
            } catch (InputMismatchException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một số");
            }
            return -1;
        }

        public void viewListBuyed (List < Animal > listBuy) {
            if (listBuy.isEmpty()) {
                System.out.println("Danh sách rỗng!");
            } else {
                for (Animal animal : listBuy) {
                    System.out.println(animal);
                }
            }
        }
    }

