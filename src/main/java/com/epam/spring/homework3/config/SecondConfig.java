package com.epam.spring.homework3.config;

import com.epam.spring.homework3.beans.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Bean;

@Configuration
@PropertySource("application.properties")
@ComponentScan("com.epam.spring.homework3")
public class SecondConfig {

    @Bean(initMethod="init",destroyMethod="destroy" )
    public BeanD beanD(){
        return new BeanD();
    }
    @Bean
    public BeanE beanE(){
        return new BeanE();
    }
    @Bean
    @Lazy
    public BeanF beanF(){
        return new BeanF();
    }
}
