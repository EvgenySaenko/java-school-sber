package ru.sber.javaschool.homework2;


public class Task implements Runnable {
    private final String name;
    private final int count;

    public Task(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "=> Началась заправка " + count + " литров " + name + " бензина");
        for (int i = 1; i <= count; i++) {
            if (!Thread.currentThread().isInterrupted()){//Если не интерапт, то продолжаю...выполнение
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " INTERRUPT ");
                    Thread.currentThread().interrupt();
                }
                System.out.print("." + ".");
            }
        }
        System.out.println(Thread.currentThread().getName() + "=> Заправка завершена");
//        System.out.println("АИ-92: 1\nАИ-95: 2\nАИ-100: 3 ");
//        System.out.print("Выберите марку бензина: ");
    }

    private void sleep(int count) throws InterruptedException {
        Thread.sleep(count);
    }
}

