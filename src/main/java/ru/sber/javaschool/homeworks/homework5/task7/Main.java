package ru.sber.javaschool.homeworks.homework5.task7;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Car hondaFreed =  new Car("HONDA","FREED",2020);
        Car hondaAccord =  new Car("HONDA","ACCORD",2014);

        BeanUtils.assign(hondaFreed,hondaAccord);

    }
}
