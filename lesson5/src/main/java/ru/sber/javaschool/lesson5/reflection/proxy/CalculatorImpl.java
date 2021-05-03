package ru.sber.javaschool.lesson5.reflection.proxy;

public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int arg) {
        System.out.println("Вызван calc:"+arg);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return arg*5;
    }
}
