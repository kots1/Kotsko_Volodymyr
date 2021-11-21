package com.epam.homework.delivery.service.impl;

import com.epam.homework.delivery.mapper.OrderMapper;
import com.epam.homework.delivery.model.Direction;
import com.epam.homework.delivery.model.Order;
import com.epam.homework.delivery.model.Tariff;
import com.epam.homework.delivery.service.DirectionService;
import com.epam.homework.delivery.service.OrderService;
import com.epam.homework.delivery.service.TariffService;
import com.epam.homework.delivery.service.UserService;
import com.epam.homework.delivery.repository.OrderRepository;
import com.epam.homework.delivery.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final TariffService tariffService;
    private final UserService userService;
    private final DirectionService directionService;

    public static double calculatePrice(Direction direction, Tariff tariff, double weight, double volume) {
        double price;
        price = tariff.getPricePerKg() * weight;
        price += tariff.getPricePerM3() * volume;
        price += tariff.getPricePerKm() * direction.getDistance();
        return price;
    }

    @Override
    public List<OrderDto> getAllOrder() {
        log.info("OrderServiceImpl getAllOrder");
        return orderRepository.getAllOrder()
                .stream()
                .map(OrderMapper.INSTANCE::orderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderByID(int id) {
        log.info("OrderServiceImpl getOrderByID id=" + id);
        return OrderMapper.INSTANCE.orderToOrderDto(orderRepository.getOrderByID(id));

    }

    @Override
    public List<OrderDto> getOrderByUserId(int userId) {
        log.info("OrderServiceImpl getOrderByUserId userId=" + userId);
        return orderRepository.getOrderByUserId(userId)
                .stream()
                .map(OrderMapper.INSTANCE::orderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrderByDirectionId(int directionId) {
        log.info("OrderServiceImpl getOrderByDirectionId directionId=" + directionId);
        return orderRepository.getOrderByDirectionId(directionId)
                .stream()
                .map(OrderMapper.INSTANCE::orderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrderByTariffId(int tariffId) {
        log.info("OrderServiceImpl getOrderByTariffId tariffId=" + tariffId);
        return orderRepository.getOrderByTariffId(tariffId)
                .stream()
                .map(OrderMapper.INSTANCE::orderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        log.info("OrderServiceImpl createOrder");
        Order order = OrderMapper.INSTANCE.orderToOrderDto(orderDto);
        if (order.getDirection() == null || order.getTariff() == null || order.getUser() == null) {
            log.info("Cannot create order");
            throw new RuntimeException("Cannot create order");
        }
        order.setPrice(calculatePrice(order.getDirection(), order.getTariff(), order.getWeight(), order.getVolume()));
        order.setOrderDate(new Date());
        return OrderMapper.INSTANCE.orderToOrderDto(orderRepository.createOrder(order));
    }

    @Override
    public OrderDto updateOrder(int id, OrderDto orderDto) {
        log.info("OrderServiceImpl updateOrder id=" + id);
        return OrderMapper.INSTANCE.orderToOrderDto(orderRepository.updateOrder(id, OrderMapper.INSTANCE.orderToOrderDto(orderDto)));
    }

    @Override
    public void deleteOrder(int id) {
        log.info("OrderServiceImpl deleteOrder id=" + id);
        orderRepository.deleteOrder(id);
    }


}
