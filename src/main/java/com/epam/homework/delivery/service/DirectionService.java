package com.epam.homework.delivery.service;

import com.epam.homework.delivery.model.Direction;
import com.epam.homework.delivery.dto.DirectionDto;

import java.util.List;

public abstract class DirectionService {
   public abstract List<DirectionDto> getAllDirection();

    public abstract DirectionDto getDirectionByID(int id);

    public abstract  Direction getDirectionByStartAndFinalCity(String startCity, String finalCity);

    public abstract  DirectionDto createDirection(DirectionDto direction);

    public abstract void deleteDirection(int id);

}
