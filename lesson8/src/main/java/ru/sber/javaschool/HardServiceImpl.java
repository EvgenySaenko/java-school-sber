package ru.sber.javaschool;

public class HardServiceImpl implements HardService{

    @Override
    public double doHardWork(String name, double item) {
        System.out.println("Вычисляем " + name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return item*50;
    }
}
