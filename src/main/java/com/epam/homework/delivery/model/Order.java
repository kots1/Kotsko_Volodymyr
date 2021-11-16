package com.epam.homework.delivery.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Order {
    private int id;
    private Tariff tariff;
    private User user;
    private Direction direction;
    private double price;
    private String description;
    private double volume;
    private double weight;
    private String orderStatus;
    private Date orderDate;

}
