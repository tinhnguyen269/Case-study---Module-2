package services.manager.impl;

import models.manager.Animal;
import reponsitories.ManagerReponsitory;
import services.manager.IManagerService;

import java.util.List;

public class ManagerService implements IManagerService {
    ManagerReponsitory managerReponsitory = new ManagerReponsitory();
    @Override
    public boolean addAnimals(Animal animal) {
        return managerReponsitory.addAnimal(animal);
    }

    @Override
    public List<Animal> getAll() {
        return managerReponsitory.getAll();
    }

    @Override
    public Animal findByCode(String code) {
        return managerReponsitory.findByCode(code);
    }

    @Override
    public Animal findByName(String name) {
        return managerReponsitory.findByName(name);
    }


    @Override
    public void deleteAnimal(Animal animalByCode) {
        managerReponsitory.deleteAnimal(animalByCode);
    }


}
