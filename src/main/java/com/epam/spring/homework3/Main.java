package com.epam.spring.homework3;

import com.epam.spring.homework3.beans.Bean;
import com.epam.spring.homework3.config.FirstConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(FirstConfig.class);
        System.out.println();
        for (String name : applicationContext.getBeanDefinitionNames()) {
            Object bean = applicationContext.getBean(name);
            if (bean instanceof Bean) {
                System.out.println(bean);
            }
        }
        System.out.println();
        applicationContext.close();
    }
}
