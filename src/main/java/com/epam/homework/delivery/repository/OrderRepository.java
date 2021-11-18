package com.epam.homework.delivery.repository;

import com.epam.homework.delivery.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getAllOrder();

    Order getOrderByID(int id);

    List<Order> getOrderByUserId(int userId);

    List<Order> getOrderByDirectionId(int directionId);

    List<Order> getOrderByTariffId(int tariffId);

    Order createOrder(Order order);

    Order updateOrder(int id, Order order);

    void deleteOrder(int id);
}
