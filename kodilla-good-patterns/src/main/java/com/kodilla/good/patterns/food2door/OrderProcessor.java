package com.kodilla.good.patterns.food2door;

public class OrderProcessor {
    private InformationService informationService;
    private ProductDatabase productDatabase;

    public OrderProcessor(InformationService informationService, ProductDatabase productDatabase){
        this.informationService = informationService;
        this.productDatabase = productDatabase;
    }

    public boolean processOrder(Order order){
        Product orderedProduct = order.getProduct();
        int orderedQuantity = order.getQuantity();
        Producer producer = order.getProducer();

        if(isOrderable(orderedProduct, orderedQuantity)){
            producer.process(orderedProduct, orderedQuantity);
            informationService.sendOrderInformation();
            productDatabase.decraseQuantity(orderedProduct, orderedQuantity);
            return true;
        } else {
            informationService.failedOrderInformation();
            return false;
        }

    }

    private boolean isOrderable(Product orderedProduct, int orderedQuantity){
        int stockQuantity = productDatabase.getQuantity(orderedProduct);

        boolean isAvailable = productDatabase.isAvailable(orderedProduct);
        boolean enoughInStock = orderedQuantity <= stockQuantity;

        return (isAvailable && enoughInStock);
    }
}
