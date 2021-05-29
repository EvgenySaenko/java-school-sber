package ru.sber.javaschool.homeworks.task2;

public class Task implements Runnable{
    private int amount;

    public Task(int amount) {
        this.amount = amount;
    }

    @Override
    public void run() {
        System.out.println("Выполняю задачу");
        for (int i = 0; i < 4; i++) {
            amount += i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Выполнил");
    }
}
