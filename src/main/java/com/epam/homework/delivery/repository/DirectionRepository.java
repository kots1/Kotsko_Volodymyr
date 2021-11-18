package com.epam.homework.delivery.repository;


import com.epam.homework.delivery.model.Direction;

import java.util.List;

public interface DirectionRepository {
    List<Direction> getAllDirection();

    Direction getDirectionByID(int id);

    Direction getDirectionByStartAndFinalCity(String startCity,String finalCity);

    Direction createDirection(Direction direction);

    void deleteDirection(int id);
}
