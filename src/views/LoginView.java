package views;

import models.login.Login;

import java.util.Scanner;

public class LoginView {
    public Login viewLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("____________Đăng nhập________");
        System.out.print("Tên đăng nhập:");
        String userName = sc.nextLine();
        System.out.print("Mật khẩu:");
        String passWord = sc.nextLine();
        Login login = new Login(userName, passWord);
        return login;
    }

    public void viewMessage(boolean result) {
        if (result) {
            System.out.println("Đăng nhập thành công");
        } else {
            System.out.println("Đăng nhập thất bại!");
        }
    }
}
