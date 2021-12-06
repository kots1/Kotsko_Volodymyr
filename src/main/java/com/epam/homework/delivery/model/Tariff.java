package com.epam.homework.delivery.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tariff")
public class Tariff {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    private String name;
    @Column(name = "price_per_km")
    private double pricePerKm;
    @Column(name = "price_per_m3")
    private double pricePerM3;
    @Column(name = "price_per_kg")
    private double pricePerKg;
    @Column(name = "max_weight")
    private double maxWeight;
    @Column(name = "max_volume")
    private double maxVolume;
    @Column(name = "time_per_100km")
    private double timePer100km;

}
