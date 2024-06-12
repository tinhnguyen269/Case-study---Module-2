package reponsitories;

import models.manager.Animal;
import models.manager.Chicken;
import models.manager.Pig;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ManagerReponsitory {
    private static final String SRC_ANIMAL = "E:\\Case study\\Module2\\manage-chicken-farm\\src\\data\\manager.csv";
    ArrayList<Animal> animals = new ArrayList<>();

    public boolean addAnimal(Animal animal) {
        if (animal == null) {
            return false;
        }
        for (Animal ani : animals) {
            if (animal.getCode().equals(ani.getCode())) {
                return false;
            }
        }
        animals.add(animal);
        writeFile(animals, false);
        return true;
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
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    public void deleteAnimal(Animal animalByCode) {
        animals.remove(animalByCode);
        writeFile(animals, false);
    }
    private void writeFile(ArrayList<Animal> animals, boolean append) {
        File file = new File(SRC_ANIMAL);
        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Animal temp : animals) {
                String animalData = animalToString(temp);
                if (animalData != null) {
                    bufferedWriter.write(animalData);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file!");
        }
    }

    public ArrayList<Animal> getAll() {
        List<Animal> animals1 = new LinkedList<>();
        File file = new File(SRC_ANIMAL);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (line.contains("GA")) {
                    animals1.add(new Chicken(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), temp[4]));
                }
                if (line.contains("HEO")) {
                    animals1.add(new Pig(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), Double.parseDouble(temp[4])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khômng tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc dữ liệu");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Lỗi đóng file");
                }
            }
        }
        animals = new ArrayList<>(animals1);
        return animals;
    }

    private String animalToString(Animal animal) {
        if (animal instanceof Chicken) {
            return animal.getCode() + "," + animal.getName() + "," + animal.getPrice() + "," + animal.getQuantity() + "," + ((Chicken) animal).getOrigin();
        }
        if (animal instanceof Pig) {
            return animal.getCode() + "," + animal.getName() + "," + animal.getPrice() + "," + animal.getQuantity() + "," + ((Pig) animal).getWeight();

        }
        return null;
    }


}
