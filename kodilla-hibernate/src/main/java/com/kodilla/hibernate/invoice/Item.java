package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS")
public final class Item {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private int id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "VALUE")
    private BigDecimal value;
    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;

    public Item() {

    }

    public Item(Product product, BigDecimal price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = price.multiply(BigDecimal.valueOf(quantity));
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
