package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private ProductDatabase productDatabase;
    private ProductOrderService productOrderService;
    private InformationService informationService;

    public OrderProcessor(ProductDatabase productDatabase, ProductOrderService productOrderService,
                          InformationService informationService) {
        this.productDatabase = productDatabase;
        this.productOrderService = productOrderService;
        this.informationService = informationService;
    }

    public void processOrder(OrderRequest orderRequest) {

        OrderDto orderDto = processOrderRequest(orderRequest);
        boolean isOrderable = productOrderService.productOrder(orderDto);

        if (isOrderable) {
            Product productOrdered = orderDto.getOrderRequest().productOrdered();
            int quantityOrdered = orderDto.getOrderRequest().quantityOrdered();

            productDatabase.decreaseQuantity(productOrdered, quantityOrdered);
            informationService.sendSomeInformationViaSomeTechnology();
        }
    }

    public OrderDto processOrderRequest(OrderRequest orderRequest) {
        if (isQuantityOrderable(orderRequest)) {
            return new OrderDto(orderRequest, true);
        } else {
            return new OrderDto(orderRequest, false);
        }
    }

    public boolean isQuantityOrderable(OrderRequest orderRequest) {

        int quantityOrdered = orderRequest.quantityOrdered();
        int quantityInStock = this.productDatabase.getQuantity(orderRequest.productOrdered());

        return (quantityInStock >= quantityOrdered);
    }
}
