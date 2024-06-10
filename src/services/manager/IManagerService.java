package services.manager;

import models.manager.Animal;

import java.util.List;


public interface IManagerService {


     boolean addAnimals(Animal animal);


     List<Animal> getAll();

     Animal findByCode(String code);

     Animal findByName(String name);

     void deleteAnimal(Animal animalByCode);
}
