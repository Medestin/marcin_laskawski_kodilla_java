package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    public boolean orderAProduct(OrderDto orderDto) {

        if(orderDto.isOrderable()){
            System.out.println("Success!");
            return true;
        } else {
            System.out.println("Sorry, order impossible to process!");
            return false;
        }
    }
}