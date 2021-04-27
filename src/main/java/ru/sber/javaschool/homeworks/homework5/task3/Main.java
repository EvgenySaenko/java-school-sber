package ru.sber.javaschool.homeworks.homework5.task3;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Car honda =  new Car("Honda","Freed Spyke",2014);
        Class<?> clazz = honda.getClass();
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().startsWith("get")){
                System.out.println(methods[i]);
            }
        }
    }
}
