package com.epam.homework.delivery.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "direction_information")
public class Direction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direction_id")
    @Id
    private Long id;
    private int distance;
    @Column(name = "final_city")
    private String finalCity;
    @Column(name = "start_city")
    private String startCity;

}
