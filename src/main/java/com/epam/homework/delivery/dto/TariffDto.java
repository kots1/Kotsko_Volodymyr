package com.epam.homework.delivery.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@Builder
public class TariffDto {
    @NotBlank
    private String name;
    @Positive
    private double pricePerKm;
    @Positive
    private double pricePerM3;
    @Positive
    private double pricePerKg;
    @Positive
    private double maxWeight;
    @Positive
    private double maxVolume;
    @Positive
    private double timePer100km;
}
