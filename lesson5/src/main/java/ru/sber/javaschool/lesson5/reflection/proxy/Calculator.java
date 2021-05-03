package ru.sber.javaschool.lesson5.reflection.proxy;

public interface Calculator {
    @Cache
    int calc(int arg);
}
