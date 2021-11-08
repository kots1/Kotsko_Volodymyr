package com.epam.spring.homework2;

import com.epam.spring.homework2.config.BeansConfig;
import com.epam.spring.homework2.other.OtherBeanC;
import com.epam.spring.homework2.pet.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeansConfig.class);
        Pet pet = applicationContext.getBean(Pet.class);
        pet.printPets();
    }
}
