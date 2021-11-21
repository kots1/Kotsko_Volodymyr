package com.epam.homework.delivery.controller;

import com.epam.homework.delivery.service.TariffService;
import com.epam.homework.delivery.dto.TariffDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TariffController {
    final TariffService tariffService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tariff")
    public List<TariffDto> getTariff() {
        return tariffService.getAllTariff();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/tariff")
    public TariffDto createTariff(@RequestBody @Valid TariffDto tariffDto) {
        return tariffService.createTariff(tariffDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tariff/{id}")
    public TariffDto getTariffById(@PathVariable int id) {
        return tariffService.getTariffByID(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/tariff/{id}")
    public void delete(@PathVariable int id) {
        tariffService.deleteTariff(id);
    }
}
