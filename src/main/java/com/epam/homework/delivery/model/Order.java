package com.epam.homework.delivery.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_tariff")
    private Tariff tariff;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_direction")
    private Direction direction;

    private double price;
    @Column(name = "description_of_baggage")
    private String description;
    private double volume;
    private double weight;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_date")
    private Date orderDate;

}
