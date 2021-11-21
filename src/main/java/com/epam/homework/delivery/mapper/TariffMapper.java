package com.epam.homework.delivery.mapper;

import com.epam.homework.delivery.dto.TariffDto;
import com.epam.homework.delivery.model.Tariff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TariffMapper {

    TariffMapper INSTANCE = Mappers.getMapper(TariffMapper.class);

    Tariff tariffToTariffDto(TariffDto tariffDto);

    TariffDto tariffToTariffDto(Tariff tariff);
}
