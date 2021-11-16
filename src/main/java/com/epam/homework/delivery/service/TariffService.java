package com.epam.homework.delivery.service;

import com.epam.homework.delivery.model.Tariff;
import com.epam.homework.delivery.model.User;
import com.epam.homework.delivery.сontroller.dto.TariffDto;
import com.epam.homework.delivery.сontroller.dto.UserDto;

import java.util.List;

public interface TariffService {
    List<TariffDto> getAllTariff();

    TariffDto getTariffByID(int id);

    Tariff getTariffByName(String name);

    TariffDto createTariff(TariffDto tariffDto);

    void deleteTariff(int id);
}
