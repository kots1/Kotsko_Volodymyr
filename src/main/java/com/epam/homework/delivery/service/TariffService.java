package com.epam.homework.delivery.service;

import com.epam.homework.delivery.model.Tariff;
import com.epam.homework.delivery.dto.TariffDto;

import java.util.List;

public interface TariffService {
    List<TariffDto> getAllTariff();

    TariffDto getTariffByID(int id);

    Tariff getTariffByName(String name);

    TariffDto createTariff(TariffDto tariffDto);

    void deleteTariff(int id);
}
