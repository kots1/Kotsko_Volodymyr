package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements InitializingBean, DisposableBean, Bean {
    private String name;
    private int value;


    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet()  {
        System.out.println("BeanA.InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void destroy()  {
        System.out.println("BeanA.DisposableBean.destroy()");
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
