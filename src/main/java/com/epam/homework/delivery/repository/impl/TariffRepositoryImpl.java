package com.epam.homework.delivery.repository.impl;

import com.epam.homework.delivery.model.Tariff;
import com.epam.homework.delivery.repository.TariffRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TariffRepositoryImpl implements TariffRepository {
    private static int ID = 1;
    private final List<Tariff> tariffs = new ArrayList<>();

    @Override
    public List<Tariff> getAllTariff() {
        return new ArrayList<>(tariffs);
    }

    @Override
    public Tariff getTariffByName(int id) {
        return tariffs.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Direction is not found!"));
    }

    @Override
    public Tariff getTariffByName(String name) {
        return tariffs.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Direction is not found!"));
    }

    @Override
    public Tariff createTariff(Tariff tariff) {
        tariff.setId(ID++);
        tariffs.add(tariff);
        return tariff;
    }

    @Override
    public void deleteTariff(int id) {
        tariffs.remove(getTariffByName(id));

    }
}
