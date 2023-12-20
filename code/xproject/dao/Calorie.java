package xproject.dao;


import xproject.model.Product;

import java.util.List;

public interface Calorie {

     List <Product> readProductsFromCSV();

     void saveFood(List<Product> products);

}
