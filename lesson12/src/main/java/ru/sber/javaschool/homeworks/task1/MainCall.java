package ru.sber.javaschool.homeworks.task1;

import java.util.concurrent.Callable;

public class MainCall {

    public static void main(String[] args) {
        Task<String> task = new Task<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                for (int i = 0; i < 4; i++) {
                    Thread.sleep(1000);
                    System.out.print("." + ".");
                }
                return "Java School";
            }
        });
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + " => " + task.get());
                } catch (Exception e) {
                    throw new ExceptionsResult("error getting the result",e);
                }
            }).start();
        }
    }
}
