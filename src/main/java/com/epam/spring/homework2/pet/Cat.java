package com.epam.spring.homework2.pet;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class Cat implements Animal{
}
