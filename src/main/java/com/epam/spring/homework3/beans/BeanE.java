package com.epam.spring.homework3.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanE {
    public BeanE() {
        System.out.println(this.getClass().getSimpleName());
    }
}
