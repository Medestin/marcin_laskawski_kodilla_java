package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OrderProcessorTestSuite {

    private ProductOrderService productOrderService = new ProductOrderService();
    private InformationService informationServiceMock = mock(InformationService.class);
    private ProductDatabase productDatabaseMock = mock(ProductDatabase.class);
    private OrderRequest orderRequestMock = mock(OrderRequest.class);
    private Product productMock = mock(Product.class);

    private OrderProcessor orderProcessor = new OrderProcessor(productDatabaseMock,
                                                                productOrderService ,informationServiceMock);

    @Before
    public void before(){
        when(orderRequestMock.productOrdered()).thenReturn(productMock);
        when(orderRequestMock.quantityOrdered()).thenReturn(10);
        when(productDatabaseMock.getQuantity(productMock)).thenReturn(100);
    }

    @Test
    public void testOrder(){
        orderProcessor.processOrder(orderRequestMock);
        verify(productDatabaseMock, times(1)).decreaseQuantity(productMock, 10);
    }

    @Test
    public void testOrderAProduct(){
        OrderDto testOrderDto = orderProcessor.processOrderRequest(orderRequestMock);

        boolean testOrderingAProduct = productOrderService.productOrder(testOrderDto);
        Assert.assertTrue(testOrderingAProduct);
    }
}
