package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanC implements Bean {
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private int value;


    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    private void init() {
        System.out.println("BeanC.initMethod");
    }

    private void destroy() {
        System.out.println("BeanC.destroyMethod");
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
