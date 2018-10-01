package com.kodilla.good.patterns.food2door;

public interface InformationService {

    void sendOrderInformation(Order order);
    void failedOrderInformation(Order order);
}
