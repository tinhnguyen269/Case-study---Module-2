package services.customer;

import models.manager.Animal;

import java.util.List;

public interface ICustomerService {
    void addListBuy(Animal animalByCode);

    List<Animal> getAll();

}
