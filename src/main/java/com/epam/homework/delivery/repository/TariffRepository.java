package com.epam.homework.delivery.repository;

import com.epam.homework.delivery.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<Tariff, Long> {


    Tariff findByName(String name);

}
