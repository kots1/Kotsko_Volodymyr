package com.epam.homework.delivery.repository;


import com.epam.homework.delivery.model.Direction;
import com.epam.homework.delivery.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectionRepository  extends JpaRepository<Direction,Long> {

    Direction getDirectionByStartCityAndFinalCity(String startCity,String finalCity);

}
