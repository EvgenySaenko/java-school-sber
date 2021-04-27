package ru.sber.javaschool.homeworks.homework5.task4;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Week week =  new Week();
        Class<?> clazz =  week.getClass();
        Field[] fields =  clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (!fields[i].isAccessible()){
                fields[i].setAccessible(true);
            }
            if (fields[i].getName().equals(fields[i].get(fields[i].getName()))){
                System.out.println(fields[i].getName() + " " + fields[i].getName().equals(fields[i].get(fields[i].getName())) +
                                                                                    " " + fields[i].get(fields[i].getName()));
            }

        }
    }
}
