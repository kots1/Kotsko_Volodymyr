package com.epam.homework.delivery.repository.impl;

import com.epam.homework.delivery.exception.EntityNotFoundException;
import com.epam.homework.delivery.model.Direction;
import com.epam.homework.delivery.repository.DirectionRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DirectionRepositoryImpl implements DirectionRepository {

    private static int ID = 1;
    private final List<Direction> directions = new ArrayList<>();

    @Override
    public List<Direction> getAllDirection() {
        return new ArrayList<>(directions);
    }

    @Override
    public Direction getDirectionByID(int id) {
        return directions.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Direction is not found!"));
    }

    @Override
    public Direction getDirectionByStartAndFinalCity(String startCity, String finalCity) {
        return directions.stream()
                .filter(e -> e.getStartCity().equals(startCity) && e.getFinalCity().equals(finalCity))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Direction is not found!"));
    }

    @Override
    public Direction createDirection(Direction direction) {
        direction.setId(ID++);
        directions.add(direction);
        return direction;
    }

    @Override
    public void deleteDirection(int id) {
        directions.remove(getDirectionByID(id));

    }
}
