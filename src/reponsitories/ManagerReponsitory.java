package reponsitories;

import models.manager.Animal;

import java.util.ArrayList;
import java.util.List;

public class ManagerReponsitory {
    ArrayList<Animal> animals = new ArrayList<>();

    public boolean addAnimal(Animal animal) {
        for (Animal ani : animals) {
            if (animal.getCode().equals(ani.getCode())) {
                return false;
            }
        }
        animals.add(animal);
        return true;
    }

    public List<Animal> getAll() {
        return new ArrayList<>(animals);
    }

    public Animal findByCode(String code) {
        for (Animal animal : animals) {
            if (animal.getCode().equals(code)) {
                return animal;
            }
        }
        return null;
    }

    public Animal findByName(String name) {
        for (Animal animal : animals) {
            if (animal.getCode().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    public void deleteAnimal(Animal animalByCode) {
        animals.remove(animalByCode);
    }
}
