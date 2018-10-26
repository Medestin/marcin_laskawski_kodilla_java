package com.kodilla.hibernate.invoice;

import com.kodilla.hibernate.invoice.dao.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave(){
        Product apple = new Product("Apple");
        Product pear = new Product("Pear");
        Product banana = new Product("Banana");

        Item apples = new Item(apple, new BigDecimal("5"), 10);
        Item pears = new Item(pear, new BigDecimal("8"), 4);
        Item bananas = new Item(banana, new BigDecimal("6"), 5);

        Invoice fruits = new Invoice("001-2018");
        fruits.getItems().add(apples);
        fruits.getItems().add(pears);
        fruits.getItems().add(bananas);

        apples.setInvoice(fruits);
        pears.setInvoice(fruits);
        bananas.setInvoice(fruits);


        invoiceDao.save(fruits);
        int invoiceId = fruits.getId();

        Assert.assertNotEquals(0 ,invoiceId);
        invoiceDao.deleteById(invoiceId);
    }
}
