package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OrderProcessorTestSuite {

    @BeforeClass
    public static void beforeClass(){

    }

    @Test
    public void testOrder(){
        ProductOrderService productOrderService = new ProductOrderService();
        InformationService informationServiceMock = mock(InformationService.class);
        ProductDatabase productDatabaseMock = mock(ProductDatabase.class);
        OrderProcessor orderProcessor = new OrderProcessor(productDatabaseMock, productOrderService ,informationServiceMock);

        Product productMock = mock(Product.class);
        OrderRequest orderRequestMock = mock(OrderRequest.class);
        when(orderRequestMock.productOrdered()).thenReturn(productMock);
        when(orderRequestMock.quantityOrdered()).thenReturn(10);

        when(productDatabaseMock.getQuantity(productMock)).thenReturn(100);


        orderProcessor.processOrder(orderRequestMock);
        verify(productDatabaseMock, times(1)).decreaseQuantity(productMock, 10);
    }

    @Test
    public void testOrderAProduct(){
        ProductOrderService productOrderService = new ProductOrderService();
        InformationService informationServiceMock = mock(InformationService.class);
        ProductDatabase productDatabaseMock = mock(ProductDatabase.class);
        OrderProcessor orderProcessor = new OrderProcessor(productDatabaseMock, productOrderService ,informationServiceMock);

        Product productMock = mock(Product.class);
        OrderRequest orderRequestMock = mock(OrderRequest.class);
        when(orderRequestMock.productOrdered()).thenReturn(productMock);
        when(orderRequestMock.quantityOrdered()).thenReturn(10);

        when(productDatabaseMock.getQuantity(productMock)).thenReturn(9);

        OrderDto testOrderDto = orderProcessor.processOrderRequest(orderRequestMock);

        boolean testOrderingAProduct = productOrderService.productOrder(testOrderDto);
        Assert.assertFalse(testOrderingAProduct);

    }
}
