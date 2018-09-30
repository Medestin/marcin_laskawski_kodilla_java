package com.kodilla.good.patterns.food2door;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class Food2DoorTestSuite {
    @Mock private InformationService informationServiceMock;
    @Mock private ProductDatabase productDatabaseMock;
    @Mock private Producer producerMock;
    @Mock private Product productMock;

    private Order testOrder;
    private OrderProcessor testOrderProcessor;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        when(productMock.getProducer()).thenReturn(producerMock);
    }

    @Test
    public void testSuccessfulOrderProcessor() {
        testOrder = new Order(productMock, 10);
        testOrderProcessor = new OrderProcessor(informationServiceMock, productDatabaseMock);

        when(productDatabaseMock.isAvailable(productMock)).thenReturn(true);
        when(productDatabaseMock.getQuantity(productMock)).thenReturn(10);

        boolean testProcessOrder = testOrderProcessor.processOrder(testOrder);

        assertTrue(testProcessOrder);
        verify(producerMock, times(1)).process(productMock, 10);
        verify(informationServiceMock, times(1)).sendOrderInformation();
        verify(productDatabaseMock, times(1)).decraseQuantity(productMock, 10);
    }

    @Test
    public void testNotEnoughProduct(){
        testOrder = new Order(productMock, 10);
        testOrderProcessor = new OrderProcessor(informationServiceMock, productDatabaseMock);

        when(productDatabaseMock.isAvailable(productMock)).thenReturn(true);
        when(productDatabaseMock.getQuantity(productMock)).thenReturn(5);

        boolean testProcessOrder = testOrderProcessor.processOrder(testOrder);

        assertFalse(testProcessOrder);
        verify(informationServiceMock, times(1)).failedOrderInformation();
    }

    @Test
    public void testUnavailableProduct(){
        testOrder = new Order(productMock, 10);
        testOrderProcessor = new OrderProcessor(informationServiceMock, productDatabaseMock);

        when(productDatabaseMock.isAvailable(productMock)).thenReturn(false);
        when(productDatabaseMock.getQuantity(productMock)).thenReturn(100);

        boolean testProcessOrder = testOrderProcessor.processOrder(testOrder);

        assertFalse(testProcessOrder);
        verify(informationServiceMock, times(1)).failedOrderInformation();
    }
}
