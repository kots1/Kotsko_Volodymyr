package com.epam.homework.delivery.service.repository;

import com.epam.homework.delivery.model.Tariff;

import java.util.List;

public interface TariffRepository {

    List<Tariff> getAllTariff();

    Tariff getTariffByName(int id);

    Tariff getTariffByName(String name);

    Tariff createTariff(Tariff tariff);

    void deleteTariff(int id);
}
