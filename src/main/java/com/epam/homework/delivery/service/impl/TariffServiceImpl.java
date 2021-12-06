package com.epam.homework.delivery.service.impl;

import com.epam.homework.delivery.exception.EntityNotFoundException;
import com.epam.homework.delivery.mapper.TariffMapper;
import com.epam.homework.delivery.model.Tariff;
import com.epam.homework.delivery.service.TariffService;
import com.epam.homework.delivery.repository.TariffRepository;
import com.epam.homework.delivery.dto.TariffDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .findAll()
                .stream()
                .map(TariffMapper.INSTANCE::tariffToTariffDto)
                .collect(Collectors.toList());
    }

    @Override
    public TariffDto getTariffByID(int id) {
        log.info("TariffServiceImpl getTariffByID id=" + id);
        Optional<Tariff> tariff = tariffRepository.findById((long) id);
        if (!tariff.isPresent()){
            throw new EntityNotFoundException("getUserByID");
        }
        return TariffMapper.INSTANCE.tariffToTariffDto(tariff.get());
    }

    @Override
    public Tariff getTariffByName(String name) {
        log.info("TariffServiceImpl getTariffByName name=" + name);
        return tariffRepository.findByName(name);

    }

    @Override
    public TariffDto createTariff(TariffDto tariffDto) {
        log.info("TariffServiceImpl createTariff ");
        Tariff tariff = TariffMapper.INSTANCE.tariffToTariffDto(tariffDto);
        return TariffMapper.INSTANCE.tariffToTariffDto(tariffRepository.save(tariff));
    }

    @Override
    public void deleteTariff(int id) {
        log.info("TariffServiceImpl deleteTariff id=" + id);
        tariffRepository.deleteById((long) id);

    }

}
