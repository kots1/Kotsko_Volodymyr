package com.epam.homework.delivery.mapper;

import com.epam.homework.delivery.dto.OrderDto;
import com.epam.homework.delivery.model.Order;
import com.epam.homework.delivery.service.DirectionService;
import com.epam.homework.delivery.service.TariffService;
import com.epam.homework.delivery.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {

    public static OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Autowired
    protected TariffService tariffService;
    @Autowired
    protected DirectionService directionService;
    @Autowired
    protected UserService userService;


    @Mappings({
            @Mapping(target = "direction", expression = "java(directionService.getDirectionByStartAndFinalCity(orderDto.getStartCity(),orderDto.getFinalCity()))"),
            @Mapping(target = "tariff", expression = "java(tariffService.getTariffByName(orderDto.getTariff()))"),
            @Mapping(target = "user", expression = "java(userService.getUserByLogin(orderDto.getLogin()))")
    })
    public abstract Order orderToOrderDto(OrderDto orderDto);

    @Mappings({
            @Mapping(target = "startCity", expression = "java(order.getDirection().getStartCity())"),
            @Mapping(target = "login", expression = "java(order.getUser().getLogin())"),
            @Mapping(target = "tariff", expression = "java(order.getTariff().getName())"),
            @Mapping(target = "finalCity", expression = "java(order.getDirection().getFinalCity())")
    })
    public abstract OrderDto orderToOrderDto(Order order);
}
