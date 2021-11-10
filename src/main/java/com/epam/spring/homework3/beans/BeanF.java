package com.epam.spring.homework3.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanF {
    public BeanF() {
        System.out.println(this.getClass().getSimpleName());
    }
}
