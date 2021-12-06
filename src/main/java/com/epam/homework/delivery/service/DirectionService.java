package com.epam.homework.delivery.service;

import com.epam.homework.delivery.dto.DirectionDto;
import com.epam.homework.delivery.model.Direction;

import java.util.List;

public interface DirectionService {
    List<DirectionDto> getAllDirection();

    DirectionDto getDirectionByID(int id);

    Direction getDirectionByStartAndFinalCity(String startCity, String finalCity);

    DirectionDto createDirection(DirectionDto direction);

    void deleteDirection(int id);

}
