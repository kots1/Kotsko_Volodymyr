package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanD implements Bean {

    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;


    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    private void init() {
        System.out.println("BeanD.initMethod");
    }

    private void destroy() {
        System.out.println("BeanD.destroyMethod");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }
}
