package com.epam.homework.delivery.mapper;

import com.epam.homework.delivery.dto.OrderDto;
import com.epam.homework.delivery.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

     OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);


    Order orderToOrderDto(OrderDto orderDto);

    OrderDto orderToOrderDto(Order order);
}
