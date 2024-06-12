package services.customer.impl;

import models.manager.Animal;
import reponsitories.CustomerReponsitory;
import services.customer.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    CustomerReponsitory customerReponsitory = new CustomerReponsitory();
    @Override
    public void addListBuy(Animal animalByCode) {
        customerReponsitory.addListBuy(animalByCode);
    }

    @Override
    public List<Animal> getAll() {
        return customerReponsitory.getAll();
    }
}
