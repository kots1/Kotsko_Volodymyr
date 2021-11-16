package com.epam.homework.delivery.сontroller;

import com.epam.homework.delivery.service.OrderService;
import com.epam.homework.delivery.сontroller.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/order")
    public List<OrderDto> getAllOrder() {
        return orderService.getAllOrder();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/order")
    public OrderDto createTariff(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{id}/order")
    public List<OrderDto> getOrderByUserId(@PathVariable int id) {
        return orderService.getOrderByUserId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/direction/{id}/order")
    public List<OrderDto> getOrderByDirectionId(@PathVariable int id) {
        return orderService.getOrderByDirectionId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tariff/{id}/order")
    public List<OrderDto> getOrderByTariffId(@PathVariable int id) {
        return orderService.getOrderByTariffId(id);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/order/{id}")
    public OrderDto getOrderById(@PathVariable int id) {
        return orderService.getOrderByID(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/order/{id}")
    public OrderDto updateUser(@PathVariable int id, @RequestBody OrderDto orderDto) {
        return orderService.updateOrder(id, orderDto);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/order/{id}")
    public void delete(@PathVariable int id) {
        orderService.deleteOrder(id);
    }
}
