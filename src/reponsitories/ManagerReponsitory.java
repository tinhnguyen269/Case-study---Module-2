package reponsitories;

import models.manager.Chicken;

import java.util.ArrayList;
import java.util.Arrays;

public class ManagerReponsitory {
    private static final Chicken[] chickens = new Chicken[1000];
    private static int count = 0;

    static {
        chickens[0] = new Chicken("1", "Gà đông tảo", 10000, 100, "Viet nam");
        count = 1;
    }

    public void addChicken(Chicken chicken) {
        chickens[count] = chicken;
        count++;
    }

    public Chicken[] getAll() {
        Chicken[] result = Arrays.copyOf(chickens, count);
        return result;
    }

    public Chicken findByCode(String code) {
        for (Chicken chicken : chickens) {
            if (chicken.getCode().equals(code)) {
                return chicken;
            }
        }
        return null;
    }

    public void deleteChicken(Chicken chicken) {
        for (int i = 0; i < count; i++) {
            if (chickens[i].getCode() == chicken.getCode()) {
                for (int j = i; j < count - 1; j++) {
                    chickens[j] = chickens[j + 1];
                }
                chickens[count - 1] = null;
                count--;
            }
        }
    }

    public boolean findAnimal(String find) {
        for (int i = 0; i < count; i++) {
            if (chickens[i].getName().equals(find) || chickens[i].getCode().equals(find)) {
                return true;
            }
        }
        return false;

    }


}
