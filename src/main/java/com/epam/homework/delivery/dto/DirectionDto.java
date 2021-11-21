package com.epam.homework.delivery.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@Builder
public class DirectionDto {
    @Positive
    private int distance;
    @NotBlank
    private String finalCity;
    @NotBlank
    private String startCity;
}
