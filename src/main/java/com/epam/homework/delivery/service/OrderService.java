package com.epam.homework.delivery.service;

import com.epam.homework.delivery.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrder();

    OrderDto getOrderByID(int id);

    List<OrderDto> getOrderByUserId(int userId);

    List<OrderDto> getOrderByDirectionId(int directionId);

    List<OrderDto> getOrderByTariffId(int tariffId);

    OrderDto createOrder(OrderDto orderDto);

    OrderDto updateOrder(int id, OrderDto orderDto);

    void deleteOrder(int id);
}
