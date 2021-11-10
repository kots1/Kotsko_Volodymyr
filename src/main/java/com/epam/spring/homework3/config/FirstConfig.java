package com.epam.spring.homework3.config;

import com.epam.spring.homework3.beans.BeanA;
import com.epam.spring.homework3.beans.BeanB;
import com.epam.spring.homework3.beans.BeanC;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.epam.spring.homework3")
@PropertySource("application.properties")
@Import(SecondConfig.class)
public class FirstConfig {

    @Bean
    public BeanA beanA(){
        return new BeanA();
    }

    @Bean(initMethod="init",destroyMethod="destroy" )
    @DependsOn("beanD")
    public BeanB beanB(){
        return new BeanB();
    }
    @Bean(initMethod="init",destroyMethod="destroy" )
    @DependsOn({"beanD","beanB"})
    public BeanC beanC(){
        return new BeanC();
    }
}
