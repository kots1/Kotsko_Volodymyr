package com.epam.spring.homework2.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Pet {
    @Autowired
    List<Animal> animals;

    public void printPets() {
        for (Animal animal:animals) {
            System.out.println(animal.getClass().getSimpleName());
        }
    }
}
