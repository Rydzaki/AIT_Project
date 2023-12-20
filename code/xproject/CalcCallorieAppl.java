package xproject;


import xproject.model.Product;

import java.util.*;

import static xproject.dao.CalorieImpl.readProductsFromCSV;
import static xproject.dao.CalorieImpl.saveFood;

public class CalcCallorieAppl {

    public static void main(String[] args) {

        List<Product> libraryFood = readProductsFromCSV(); // прочитали библиотеку продуктов
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi! Input your food: ");
        String food = scanner.nextLine().toUpperCase();

        List<Product> userProduct = new ArrayList<>();

        System.out.println("Input how many grams: ");
        int gram = scanner.nextInt();

       // System.out.println("Input date: ");

        int userGram = 0;


        for (Product product: libraryFood) {
            if(food.equalsIgnoreCase(product.getName())){
                userGram = product.getCalorie()/100 * gram; // съеденные калории
                userProduct.add(new Product(food, userGram)); //фактический список юзера
            }
        }
        saveFood(userProduct);

//        1. Ввести данные
//        2.загрузить данные (Считать с листа из файла)
//        3.Удалить добавленный продукт
//        4. Вывести весь список (за период в будущем)
//        5. Сохранить список
//                5. выйти
//
//        sumCal(userProduct);
//        sumCalMorning(userProduct);






    }
}
