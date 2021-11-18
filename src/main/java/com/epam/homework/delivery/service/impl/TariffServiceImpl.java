package com.epam.homework.delivery.service.impl;

import com.epam.homework.delivery.model.Tariff;
import com.epam.homework.delivery.service.TariffService;
import com.epam.homework.delivery.repository.TariffRepository;
import com.epam.homework.delivery.сontroller.dto.TariffDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService {
    private final TariffRepository tariffRepository;

    @Override
    public List<TariffDto> getAllTariff() {
        log.info("TariffServiceImpl getAllTariff ");
        return tariffRepository
                .getAllTariff()
                .stream()
                .map(this::mapTariffToTariffDto)
                .collect(Collectors.toList());
    }

    @Override
    public TariffDto getTariffByID(int id) {
        log.info("TariffServiceImpl getTariffByID id=" + id);
        return mapTariffToTariffDto(tariffRepository.getTariffByName(id));
    }

    @Override
    public Tariff getTariffByName(String name) {
        log.info("TariffServiceImpl getTariffByName name=" + name);
        return tariffRepository.getTariffByName(name);

    }

    @Override
    public TariffDto createTariff(TariffDto tariffDto) {
        log.info("TariffServiceImpl createTariff ");
        Tariff tariff = mapTariffDtoToTariff(tariffDto);
        return mapTariffToTariffDto(tariffRepository.createTariff(tariff));
    }

    @Override
    public void deleteTariff(int id) {
        log.info("TariffServiceImpl deleteTariff id=" + id);
        tariffRepository.deleteTariff(id);

    }

    private TariffDto mapTariffToTariffDto(Tariff tariff) {
        return TariffDto
                .builder()
                .maxVolume(tariff.getMaxVolume())
                .maxWeight(tariff.getMaxWeight())
                .name(tariff.getName())
                .pricePerKg(tariff.getPricePerKg())
                .pricePerKm(tariff.getPricePerKm())
                .pricePerM3(tariff.getPricePerM3())
                .timePer100km(tariff.getTimePer100km())
                .build();
    }

    private Tariff mapTariffDtoToTariff(TariffDto tariffDto) {
        return Tariff
                .builder()
                .maxVolume(tariffDto.getMaxVolume())
                .maxWeight(tariffDto.getMaxWeight())
                .name(tariffDto.getName())
                .pricePerKg(tariffDto.getPricePerKg())
                .pricePerKm(tariffDto.getPricePerKm())
                .pricePerM3(tariffDto.getPricePerM3())
                .timePer100km(tariffDto.getTimePer100km())
                .build();
    }
}
