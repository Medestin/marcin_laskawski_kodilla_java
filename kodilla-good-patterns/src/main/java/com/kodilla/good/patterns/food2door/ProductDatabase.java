package com.kodilla.good.patterns.food2door;

public interface ProductDatabase {

    int getQuantity(Product product);
    void decraseQuantity(Product product, int quantity);
    boolean isAvailable(Product product);
}
