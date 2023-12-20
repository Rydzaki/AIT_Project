package xproject.dao;



import xproject.model.Product;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CalorieImpl {

    private List <Product> products;
    private LocalDate date;

    public CalorieImpl(List <Product> products, LocalDate date) {
        this.products = products;
        this.date = date;
    }

    public static List <Product> readProductsFromCSV() {
        List <Product> productList = new ArrayList <>();

        try (BufferedReader br = new BufferedReader(new FileReader("code/xproject/Product.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 2) {
                    String name = data[0].toUpperCase();
                    int calories = Integer.parseInt(data[1]);

                    productList.add(new Product(name, calories));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        productList.forEach(System.out::println); // todo убрать

        return productList;
    }


    public static void saveFood(List<Product> products) {
        String filePath = "./saved_food.txt";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(products);
            System.out.println("\nЕда сохранена.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public List <Product> getProducts() {
        return products;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalorieImpl calorie = (CalorieImpl) o;
        return Objects.equals(date, calorie.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return "CalorieImpl{" +
                "products=" + products +
                ", date=" + date +
                '}';
    }

    // todo  добавить или с запись или в апликацию

    //  PrintWriter pw = new PrintWriter(new FileWriter(str, true)); // поставили флаг - добавление это true(позволяет дополнять, а не перезаписывать файл) / создаем поток символов в файл
    //        System.out.println("Type the text here ");
    //        str = br.readLine();
    //        while (!"stop".equalsIgnoreCase(str)){ // пока строка не равна STOP будем продолжать цикл
    //            pw.println(str);
    //            System.out.println("Type the text here ");
    //            str = br.readLine();
    //        }
    //        pw.flush();// отправление из буфера в поток => файл
    //        pw.close(); // закрываем файл
}
