package ru.sber.javaschool.homework;


public class Task implements Runnable {
    private final String name;
    private final int count;

    public Task(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Началась заправка " + count + " литров " + name + " бензина");
        for (int i = 1; i <= count; i++) {
            sleep(1000);
            System.out.print("."+ ".");
        }
        System.out.println(Thread.currentThread().getName()+ " Заправка завершена");
//        System.out.println("АИ-92: 1\nАИ-95: 2\nАИ-100: 3 ");
//        System.out.print("Выберите марку бензина: ");
    }

    private void sleep(int count) {
        try {
            Thread.sleep(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
