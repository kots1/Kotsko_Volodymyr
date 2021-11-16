package com.epam.homework.delivery.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Direction {
    private int id;
    private int distance;
    private String finalCity;
    private String startCity;

}
