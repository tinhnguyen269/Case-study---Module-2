package controllers;
import models.manager.Animal;
import models.login.Login;
import services.customer.impl.CustomerService;
import services.login.LoginService;
import services.manager.impl.ManagerService;
import views.CustomerView;
import views.IndexView;
import views.LoginView;
import views.ManagerView;
import java.util.List;

public class MainController {
    public static void main(String[] args) {
        ManagerView managerView = new ManagerView();
        ManagerService managerService = new ManagerService();
        CustomerService customerService = new CustomerService();

        IndexView indexView = new IndexView();
        CustomerView customerView = new CustomerView();
        LoginView loginView = new LoginView();
        int choiceIndex;
        int choiceManager;
        int choiceCustomer;
        int choiceAnimal;

        Login login;
        String code;
        String name;
        boolean checkLogin;
        Animal animal, animalByCode, animalByName;
        boolean check = true;


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
                    choiceManager = managerView.viewMenu();
                    switch (choiceManager) {
// Thêm vật nuôi
                        case 1:
                            choiceAnimal = managerView.choiceAnimal();
                            if (choiceAnimal == 1) {
                                animal = managerView.viewAddChicken();
                                check = managerService.addAnimals(animal);
                            }
                            if (choiceAnimal == 2) {
                                animal = managerView.viewAddPig();
                                check = managerService.addAnimals(animal);
                            }

                            if (check) {
                                managerView.viewMessage(true);
                            } else {
                                managerView.viewMessage(false);
                            }
                            break;
//  Sửa thông tin
                        case 2:
                            choiceAnimal = managerView.choiceAnimal();
                            code = managerView.findByCode();
                            animalByCode = managerService.findByCode(code);
                            if (animalByCode == null) {
                                managerView.viewMessage(false);
                            } else {
                                managerView.updateAnimal(choiceAnimal, animalByCode);
                            }
                            break;

// Xóa vật nuôi
                        case 3:
                            code = managerView.findByCode();
                            animalByCode = managerService.findByCode(code);
                            if (animalByCode == null) {
                                managerView.viewMessage(false);
                            } else {
                                boolean confirm = managerView.viewConfirmDelete(animalByCode);
                                if (confirm) {
                                    managerService.deleteAnimal(animalByCode);
                                    managerView.viewMessage(true);
                                }
                            }
                            break;
// Hiển thị danh sách
                        case 4:
                            List<Animal> animalList = managerService.getAll();
                            managerView.viewAll(animalList);
                            break;

//  Tìm kiếm
                        case 5:
                            code = managerView.findByCode();
                            name = managerView.findByName();
                            animalByCode = managerService.findByCode(code);
                            animalByName = managerService.findByName(name);
                            managerView.DisplayFind(animalByCode, animalByName);

                            break;
// Hiển thị danh sách vật nuôi đã bán
                        case 6:
                            List<Animal> listBuy = customerService.getAll();
                            customerView.viewListBuyed(listBuy);
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
                while (true) {
                    choiceCustomer = customerView.customerViewMenu();
                    switch (choiceCustomer) {
                        case 1:
                            code = managerView.findByCode();
                            name = managerView.findByName();
                            animalByCode = managerService.findByCode(code);
                            animalByName = managerService.findByName(name);
                            managerView.DisplayFind(animalByCode, animalByName);
                            break;
                        case 2:
                            List<Animal> animalList = managerService.getAll();
                            managerView.viewAll(animalList);
                            break;
                        case 3:
                            code = managerView.findByCode();
                            animalByCode = managerService.findByCode(code);
                            if (animalByCode == null) {
                                managerView.viewMessage(false);
                            } else {
                                boolean confirm = CustomerView.viewConfirmBuy(animalByCode);
                                if (confirm) {
                                    managerService.deleteAnimal(animalByCode);
                                    managerView.viewMessage(true);
                                    customerService.addListBuy(animalByCode);
                                }
                            }
                            break;
                        case 4:
                            List<Animal> listBuy = customerService.getAll();
                            customerView.viewListBuyed(listBuy);
                            break;
                        case 5:
                            break;
                    }
                    if (choiceCustomer == 5) {
                        break;
                    }
                }
            }
        }
    }
}



