package com.epam.homework.delivery.service.impl;

import com.epam.homework.delivery.exception.EntityNotFoundException;
import com.epam.homework.delivery.mapper.DirectionMapper;
import com.epam.homework.delivery.model.Direction;
import com.epam.homework.delivery.model.Tariff;
import com.epam.homework.delivery.service.DirectionService;
import com.epam.homework.delivery.repository.DirectionRepository;
import com.epam.homework.delivery.dto.DirectionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DirectionServiceImpl implements DirectionService {
    private final DirectionRepository directionRepository;

    @Override
    public List<DirectionDto> getAllDirection() {
        log.info("DirectionServiceImpl getAllDirection");
        return directionRepository.findAll()
                .stream()
                .map(DirectionMapper.INSTANCE::directionToDirectionDto)
                .collect(Collectors.toList());
    }

    @Override
    public DirectionDto getDirectionByID(int id) {
        log.info("DirectionServiceImpl getDirectionByID id=" + id);
        Optional<Direction> direction = directionRepository.findById((long) id);
        if (!direction.isPresent()){
            throw new EntityNotFoundException("getDirectionByID");
        }
        return DirectionMapper.INSTANCE.directionToDirectionDto(direction.get());
    }

    @Override
    public Direction getDirectionByStartAndFinalCity(String startCity, String finalCity) {
        log.info("DirectionServiceImpl getDirectionByStartAndFinalCity startCity=" + startCity + ",finalCity=" + finalCity);
        return directionRepository.getDirectionByStartCityAndFinalCity(startCity, finalCity);
    }

    @Override
    public DirectionDto createDirection(DirectionDto directionDto) {
        log.info("DirectionServiceImpl createDirection");
        Direction direction = DirectionMapper.INSTANCE.directionToDirectionDto(directionDto);
        return DirectionMapper.INSTANCE.directionToDirectionDto(directionRepository.save(direction));
    }

    @Override
    public void deleteDirection(int id) {
        log.info("DirectionServiceImpl deleteDirection id=" + id);
        directionRepository.deleteById((long) id);
    }

}
