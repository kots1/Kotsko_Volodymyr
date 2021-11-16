package com.epam.homework.delivery.сontroller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {
    private String tariff;
    private String login;
    private String startCity;
    private String finalCity;
    private double price;
    private double volume;
    private double weight;
    private String orderStatus;
}
