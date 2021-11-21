package com.epam.homework.delivery.repository.impl;

import com.epam.homework.delivery.exception.EntityNotFoundException;
import com.epam.homework.delivery.model.Order;
import com.epam.homework.delivery.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    private static int ID = 1;
    private final List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> getAllOrder() {
        return new ArrayList<>(orders);
    }

    @Override
    public Order getOrderByID(int id) {
        return orders.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Direction is not found!"));
    }

    @Override
    public List<Order> getOrderByUserId(int userId) {
        return orders.stream()
                .filter(e -> e.getUser().getId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrderByDirectionId(int directionId) {
        return orders.stream()
                .filter(e -> e.getDirection().getId() == directionId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrderByTariffId(int tariffId) {
        return orders.stream()
                .filter(e -> e.getTariff().getId() == tariffId)
                .collect(Collectors.toList());
    }

    @Override
    public Order createOrder(Order order) {
        order.setId(ID++);
        orders.add(order);
        return order;
    }

    @Override
    public Order updateOrder(int id, Order order) {
        boolean isDeleted = orders.removeIf(u -> u.getId() == id);
        if (isDeleted) {
            orders.add(order);
        } else {
            throw new EntityNotFoundException("Order is not found!");
        }
        return order;
    }

    @Override
    public void deleteOrder(int id) {
        orders.remove(getOrderByID(id));

    }
}
