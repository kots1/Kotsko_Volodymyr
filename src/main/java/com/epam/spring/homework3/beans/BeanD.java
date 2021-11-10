package com.epam.spring.homework3.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanD {
    public BeanD() {
        System.out.println(this.getClass().getSimpleName());
    }
}
