package com.kodilla.good.patterns.challenges;

public class OrderDto {
    private final OrderRequest orderRequest;
    private final boolean isOrderable;

    public OrderDto(final OrderRequest orderRequest, final boolean isOrderable){
        this.orderRequest = orderRequest;
        this.isOrderable = isOrderable;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public boolean isOrderable() {
        return isOrderable;
    }
}
