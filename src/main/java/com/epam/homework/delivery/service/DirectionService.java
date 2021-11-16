package com.epam.homework.delivery.service;

import com.epam.homework.delivery.model.Direction;
import com.epam.homework.delivery.model.User;
import com.epam.homework.delivery.сontroller.dto.DirectionDto;

import java.util.List;

public interface DirectionService {
    List<DirectionDto> getAllDirection();

    DirectionDto getDirectionByID(int id);

    Direction getDirectionByStartAndFinalCity(String startCity, String finalCity);

    DirectionDto createDirection(DirectionDto direction);

    void deleteDirection(int id);

}
