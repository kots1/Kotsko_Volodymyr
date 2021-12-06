package com.epam.homework.delivery.service;

import com.epam.homework.delivery.dto.OrderDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrder();
    List<OrderDto> getAllOrder(Pageable page);

    OrderDto getOrderByID(int id);

    List<OrderDto> getOrderByUserId(int userId);

    List<OrderDto> getOrderByDirectionId(int directionId);

    List<OrderDto> getOrderByTariffId(int tariffId);

    OrderDto createOrder(OrderDto orderDto);


    void deleteOrder(int id);
}
