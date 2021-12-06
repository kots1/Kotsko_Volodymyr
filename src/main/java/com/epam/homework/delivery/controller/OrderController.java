package com.epam.homework.delivery.controller;

import com.epam.homework.delivery.service.OrderService;
import com.epam.homework.delivery.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/order")
    public List<OrderDto> getAllOrder() {
        Pageable sortedByName =
                PageRequest.of(0, 3, Sort.by("price"));

        return orderService.getAllOrder(sortedByName);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/order")
    public OrderDto createTariff(@RequestBody @Valid OrderDto orderDto) {
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


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/order/{id}")
    public void delete(@PathVariable int id) {
        orderService.deleteOrder(id);
    }
}
