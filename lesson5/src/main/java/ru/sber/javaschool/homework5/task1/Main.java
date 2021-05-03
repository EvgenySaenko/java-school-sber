package ru.sber.javaschool.homework5.task1;

public class Main {

    public static void main(String[] args) {
        Calculator calc =  new CalculatorImpl();
        calc.calc(5);
        System.out.println(calc.calc(5));
    }
}
