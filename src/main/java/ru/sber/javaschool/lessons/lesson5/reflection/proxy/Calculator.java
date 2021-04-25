package ru.sber.javaschool.lessons.lesson5.reflection.proxy;

public interface Calculator {
    @Cache
    int calc(int arg);
}
