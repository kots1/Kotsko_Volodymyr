package com.epam.spring.homework2.other;

import com.epam.spring.homework2.beans.BeanC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherBeanC {
    @Autowired
    private BeanC beanC;

    /*
     * Вивід: null
     * Причина: порядок створення Bean.
     * 1.Сторюється сам об'єкт(виконується конструктор)
     * 2.Налаштування біна, а саме ініціалізуються залежності(присвоєння beanC)
     * */
    public OtherBeanC() {
        System.out.println(beanC);
    }

}
