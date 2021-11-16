package com.epam.homework.delivery.сontroller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DirectionDto {
    private int distance;
    private String finalCity;
    private String startCity;
}
