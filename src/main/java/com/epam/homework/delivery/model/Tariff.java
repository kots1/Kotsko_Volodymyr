package com.epam.homework.delivery.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tariff  {
    private int id;
    private String name;
    private double pricePerKm;
    private double pricePerM3;
    private double pricePerKg;
    private double maxWeight;
    private double maxVolume;
    private double timePer100km;

}
