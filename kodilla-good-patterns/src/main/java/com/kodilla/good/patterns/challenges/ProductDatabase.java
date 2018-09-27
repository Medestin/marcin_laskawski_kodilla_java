package com.kodilla.good.patterns.challenges;

public interface ProductDatabase {

    int getQuantityOfAProduct(Product product);
    void subtractQuantityOfAProduct(Product product, int quantity);

}
