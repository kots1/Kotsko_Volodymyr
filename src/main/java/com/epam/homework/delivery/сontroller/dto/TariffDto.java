package com.epam.homework.delivery.сontroller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TariffDto {
    private String name;
    private double pricePerKm;
    private double pricePerM3;
    private double pricePerKg;
    private double maxWeight;
    private double maxVolume;
    private double timePer100km;
}
