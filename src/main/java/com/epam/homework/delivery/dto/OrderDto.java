package com.epam.homework.delivery.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@Builder
public class OrderDto {
    @NotBlank
    private String tariff;
    @NotBlank
    private String login;
    @NotBlank
    private String startCity;
    @NotBlank
    private String finalCity;
    private double price;
    @Positive
    private double volume;
    @Positive
    private double weight;
    @NotBlank
    private String orderStatus;
}
