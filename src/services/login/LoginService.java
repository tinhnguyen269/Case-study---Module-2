package services.login;

import models.login.Login;
import reponsitories.LoginReponsitory;

public class LoginService  {
   static LoginReponsitory loginReponsitory = new LoginReponsitory();
    public static boolean checkLoginManager(Login login) {
        return loginReponsitory.CheckLoginManeger(login);
    }

    public static boolean checkLoginCustomer(Login login) {
        return loginReponsitory.checkLoginCustomer(login);
    }
}
