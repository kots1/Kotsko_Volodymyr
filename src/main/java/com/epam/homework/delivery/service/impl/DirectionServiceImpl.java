package com.epam.homework.delivery.service.impl;

import com.epam.homework.delivery.model.Direction;
import com.epam.homework.delivery.service.DirectionService;
import com.epam.homework.delivery.service.repository.DirectionRepository;
import com.epam.homework.delivery.сontroller.dto.DirectionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DirectionServiceImpl implements DirectionService {
    private final DirectionRepository directionRepository;

    @Override
    public List<DirectionDto> getAllDirection() {
        log.info("DirectionServiceImpl getAllDirection");
        return directionRepository.getAllDirection()
                .stream()
                .map(this::mapDirectionToDirectionDto)
                .collect(Collectors.toList());
    }

    @Override
    public DirectionDto getDirectionByID(int id) {
        log.info("DirectionServiceImpl getDirectionByID id=" + id);
        return mapDirectionToDirectionDto(directionRepository.getDirectionByID(id));
    }

    @Override
    public Direction getDirectionByStartAndFinalCity(String startCity, String finalCity) {
        log.info("DirectionServiceImpl getDirectionByStartAndFinalCity startCity=" + startCity + ",finalCity=" + finalCity);
        return directionRepository.getDirectionByStartAndFinalCity(startCity, finalCity);
    }

    @Override
    public DirectionDto createDirection(DirectionDto directionDto) {
        log.info("DirectionServiceImpl createDirection");
        Direction direction = mapDirectionDtoToDirection(directionDto);
        return mapDirectionToDirectionDto(directionRepository.createDirection(direction));
    }

    @Override
    public void deleteDirection(int id) {
        log.info("DirectionServiceImpl deleteDirection id=" + id);
        directionRepository.deleteDirection(id);
    }

    private DirectionDto mapDirectionToDirectionDto(Direction direction) {
        return DirectionDto
                .builder().distance(direction.getDistance())
                .finalCity(direction.getFinalCity())
                .startCity(direction.getStartCity())
                .build();
    }

    private Direction mapDirectionDtoToDirection(DirectionDto directionDto) {
        return Direction
                .builder()
                .distance(directionDto.getDistance())
                .finalCity(directionDto.getFinalCity())
                .startCity(directionDto.getStartCity())
                .build();
    }
}
