package com.epam.spring.homework3.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanC {
    public BeanC() {
        System.out.println(this.getClass().getSimpleName());
    }
}
