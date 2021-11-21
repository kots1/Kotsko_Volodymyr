package com.epam.homework.delivery.dto;

import com.epam.homework.delivery.model.Direction;
import com.epam.homework.delivery.model.Tariff;
import com.epam.homework.delivery.model.User;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
public class OrderDto {
    @NotNull
    private Tariff tariff;
    @NotNull
    private User user;
    @NotNull
    private Direction direction;
    private double price;
    @Positive
    private double volume;
    @Positive
    private double weight;
    @NotBlank
    private String orderStatus;
}
