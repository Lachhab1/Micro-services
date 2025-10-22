package net.ccn36.part3.billingservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private String id;
    private String name;
    private int quantity;
    private double price;
}
