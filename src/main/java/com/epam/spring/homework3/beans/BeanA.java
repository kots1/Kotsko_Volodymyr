package com.epam.spring.homework3.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanA {
    public BeanA() {
        System.out.println(this.getClass().getSimpleName());
    }
}
