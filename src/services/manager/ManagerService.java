package services.manager;

import models.manager.Chicken;

public interface ManagerService<T > {
    void addChiken(Chicken chicken);

    Chicken findByCode(String code);

    void deleteChicken(Chicken chicken);
}
