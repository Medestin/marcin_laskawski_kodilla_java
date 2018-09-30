package com.kodilla.good.patterns.challenges;

public interface ProductDatabase {

    int getQuantity(Product product);
    void decreaseQuantity(Product product, int quantity);
}
