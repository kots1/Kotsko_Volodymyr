package com.epam.homework.delivery.mapper;

import com.epam.homework.delivery.dto.DirectionDto;
import com.epam.homework.delivery.model.Direction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DirectionMapper {

    DirectionMapper INSTANCE = Mappers.getMapper(DirectionMapper.class);

    Direction directionToDirectionDto(DirectionDto directionDto);

    DirectionDto directionToDirectionDto(Direction direction);
}
