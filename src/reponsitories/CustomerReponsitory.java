package reponsitories;

import models.manager.Animal;
import models.manager.Chicken;
import models.manager.Pig;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerReponsitory {
    private static final String SRC_CUSTOMER = "E:\\Case study\\Module2\\manage-chicken-farm\\src\\data\\customer.csv";
    ArrayList<Animal> listBuy = new ArrayList<>();

    public void addListBuy(Animal animalByCode) {
        listBuy.add(animalByCode);
        writeFile(listBuy, true);
    }

    public List<Animal> getAll() {
        List<Animal> listBuys = new ArrayList<>();
        File file = new File(SRC_CUSTOMER);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                if (line.contains("GA")) {
                    listBuys.add(new Chicken(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), temp[4]));
                }
                if (line.contains("HEO")) {
                    listBuys.add(new Pig(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), Double.parseDouble(temp[4])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không thấy file!");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file!");
        }finally {
            try{
                if(bufferedReader!= null){
                    bufferedReader.close();
                }
            }catch (IOException e){
                System.out.println("Lỗi đọc file!");
            }
        }
        return listBuys;
    }

    public void writeFile(ArrayList<Animal> listBuy, boolean append) {
        File file = new File(SRC_CUSTOMER);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Animal temp : listBuy) {
                bufferedWriter.write(toStringListBuy(temp));
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khômng tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc dữ liệu");
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("Lỗi đóng file!");
                }
            }
        }
    }

    public String toStringListBuy(Animal animal) {
        if (animal instanceof Chicken) {
            return animal.getCode() + "," + animal.getName() + "," + animal.getPrice() + "," + animal.getQuantity() + "," + ((Chicken) animal).getOrigin();
        }
        if (animal instanceof Pig) {
            return animal.getCode() + "," + animal.getName() + "," + animal.getPrice() + "," + animal.getQuantity() + "," + ((Pig) animal).getWeight();
        }
        return null;
    }

}
