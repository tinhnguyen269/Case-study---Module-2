package controllers;

import models.manager.Chicken;
import models.login.Login;
import models.manager.Pig;
import services.manager.ChickenService;
import services.login.LoginService;
import services.manager.PigService;
import views.CustomerView;
import views.IndexView;
import views.LoginView;
import views.ManagerView;

public class MainController {
    public static void main(String[] args) {
        ManagerView managerView = new ManagerView();
        ChickenService chickenService = new ChickenService();
        IndexView indexView = new IndexView();
        CustomerView customerView = new CustomerView();
        LoginView loginView = new LoginView();
        int choiceIndex, choiceManager, choiceCustomer,choiceAnimal;
        Chicken chicken;
        Pig pig;
        Login login;
        String code,find;
        boolean checkLogin;


        while (true) {
            choiceIndex = indexView.indexView();
            if (choiceIndex == 1) {
                do {
                    login = loginView.viewLogin();
                    checkLogin = LoginService.checkLoginManager(login);
                    if (checkLogin) {
                        loginView.viewMessage(true);
                    } else {
                        loginView.viewMessage(false);
                    }
                }
                while (!checkLogin);

                while (true) {
                    choiceManager = managerView.view();
                    switch (choiceManager) {
// Thêm vật nuôi
                        case 1:
                           choiceAnimal = managerView.choiceAnimal();
                           switch (choiceAnimal){
                               case 1:
                                   chicken = managerView.viewAddChicken();
                                   chickenService.addChiken(chicken);
                                   managerView.viewMessage(true);
                                   break;
                               case 2:
                                   pig = managerView.viewAddPig();
                                   PigService.addPig(pig);


                           }

//  Sửa thông tin
                        case 2:
                            code = managerView.findByCode();
                            chicken = chickenService.findByCode(code);
                            if (chicken == null) {
                                managerView.viewMessage(false);
                            } else {
                                Chicken update = managerView.updateChicken(chicken);
                            }
                            break;
// Xóa vật nuôi
                        case 3:
                            code = managerView.findByCode();
                            chicken = chickenService.findByCode(code);
                            if (chicken == null) {
                                managerView.viewMessage(false);
                            } else {
                                boolean confirm = managerView.viewConfirmDelete();
                                if (confirm) {
                                    chickenService.deleteChicken(chicken);
                                    managerView.viewMessage(true);
                                }
                            }
                            break;
// Hiển thị danh sách
                        case 4:
                            Chicken[] chickens = ChickenService.getAll();
                            managerView.viewALL(chickens);
                            break;

//  Tìm kiếm
                        case 5:
                            find = managerView.findAnimal();
                            boolean check = ChickenService.findAnimal(find);
                            if(check){

                            }

                            break;
// Hiển thị danh sách vật nuôi đã bán
                        case 6:
                            break;
// Quay về trang chủ
                        case 7:
                            break;
                    }
                    if (choiceManager == 7) {
                        break;
                    }
                }
            }

            if (choiceIndex == 2) {

                do {
                    login = loginView.viewLogin();
                    checkLogin = LoginService.checkLoginCustomer(login);
                    if (checkLogin) {
                        loginView.viewMessage(true);
                    } else {
                        loginView.viewMessage(false);
                    }
                }
                while (!checkLogin);
                customerView.customerView();

            }
        }
    }

}



