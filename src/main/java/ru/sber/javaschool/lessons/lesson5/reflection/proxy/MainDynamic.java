package ru.sber.javaschool.lessons.lesson5.reflection.proxy;

import java.lang.reflect.Proxy;

public class MainDynamic {

    public static void main(String[] args) {
        Calculator delegate=new CalculatorImpl();
        Calculator calculator= (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CachedInvocationHandler(delegate));
        run(calculator);
    }
    private static void run(Calculator calculator){
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(5));
        System.out.println(calculator.calc(6));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));

    }
}
