package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanB implements Bean {
    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private int value;



    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    private void init() {
        System.out.println("BeanB.initMethod");
    }
    private void changeInit() {
        System.out.println("BeanB.changeInitMethod");
    }
    private void destroy() {
        System.out.println("BeanB.destroyMethod");
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
