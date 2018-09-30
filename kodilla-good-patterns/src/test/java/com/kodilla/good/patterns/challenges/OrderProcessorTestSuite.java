package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OrderProcessorTestSuite {

    private ProductOrderService productOrderService;
    private InformationService informationServiceMock;
    private ProductDatabase productDatabaseMock;
    private OrderRequest orderRequestMock;
    private Product productMock;

    private OrderProcessor orderProcessor;

    @Before
    public void before() {
        productOrderService = new ProductOrderService();
        informationServiceMock = mock(InformationService.class);
        productDatabaseMock = mock(ProductDatabase.class);
        orderRequestMock = mock(OrderRequest.class);
        productMock = mock(Product.class);

        orderProcessor = new OrderProcessor(productDatabaseMock,
                productOrderService, informationServiceMock);
    }

    @Test
    public void testOrder() {
        when(orderRequestMock.productOrdered()).thenReturn(productMock);
        when(orderRequestMock.quantityOrdered()).thenReturn(10);
        when(productDatabaseMock.getQuantity(productMock)).thenReturn(100);

        orderProcessor.processOrder(orderRequestMock);
        verify(productDatabaseMock, times(1)).decreaseQuantity(productMock, 10);
    }

    @Test
    public void testOrderAProduct() {
        when(orderRequestMock.productOrdered()).thenReturn(productMock);
        when(orderRequestMock.quantityOrdered()).thenReturn(10);
        when(productDatabaseMock.getQuantity(productMock)).thenReturn(9);

        OrderDto testOrderDto = orderProcessor.processOrderRequest(orderRequestMock);

        boolean testOrderingAProduct = productOrderService.productOrder(testOrderDto);
        Assert.assertFalse(testOrderingAProduct);
    }
}
