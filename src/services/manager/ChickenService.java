package services.manager;

import models.manager.Chicken;
import reponsitories.ManagerReponsitory;

public class ChickenService implements ManagerService {
    static ManagerReponsitory chickenReponsitory = new ManagerReponsitory();

    public static Chicken[] getAll() {
       return chickenReponsitory.getAll();
    }

    public static boolean findAnimal(String find) {
        return chickenReponsitory.findAnimal(find);
    }

    @Override
    public void addChiken(Chicken chicken) {
        chickenReponsitory.addChicken(chicken);

    }

    @Override
    public Chicken findByCode(String code) {
        return chickenReponsitory.findByCode(code);
    }

    @Override
    public void deleteChicken(Chicken chicken) {
        chickenReponsitory.deleteChicken(chicken);
    }


}
