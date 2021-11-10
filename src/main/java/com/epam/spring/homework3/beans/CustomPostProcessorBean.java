package com.epam.spring.homework3.beans;

import com.epam.spring.homework3.beans.Bean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomPostProcessorBean implements BeanPostProcessor {


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Bean){
            Bean custom = (Bean) bean;
            if (custom.getName()==null||custom.getValue()<0){
                System.out.println(beanName+" is not valid");
            }
        }
        return bean;
    }
}
