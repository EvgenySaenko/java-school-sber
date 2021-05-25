package ru.sber.javaschool.homework;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainApp {

    public static void welcome() {
        System.out.println("АИ-92: 1\nАИ-95: 2\nАИ-100: 3 ");
        System.out.print("Выберите марку бензина: ");
    }

    public static void main(String[] args) {
        Task task1 =  new Task("AI-95",4);
        Task task2 =  new Task("AI-92",5);
        Task task3 =  new Task("AI-98",7);
        Task task4 =  new Task("AI-100",8);
        Task task5 =  new Task("AI-100",9);

        ThreadPool pool = new FixedThreadPool(2);

        pool.start();
        pool.execute(task1);

        pool.execute(task2);

        pool.execute(task3);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.execute(task4);
        pool.execute(task5);





        //fuelFilling(pool);


    }

    private static void fuelFilling(ThreadPool pool) {
        Scanner sc = new Scanner(System.in);
        welcome();
        boolean active = true;
        while (active) {
            if (sc.hasNext()){
                int number = sc.nextInt();
                if (number == 1) {
                    System.out.println("Вы выбрали АИ-92");
                    System.out.print("Введите количество литров: ");

                    if (sc.hasNext()) {
                        int count = sc.nextInt();
                        Task fanta = new Task("АИ-92", count);
                        pool.execute(() -> fanta.run());
                    }
                }
                if (number == 2) {
                    System.out.println("Вы выбрали АИ-95");
                    System.out.print("Введите количество литров: ");

                    if (sc.hasNext()) {
                        int count = sc.nextInt();
                        Task pepsi = new Task("АИ-95", count);
                        pool.execute(() -> pepsi.run());
                    }
                }
                if (number == 3){
                    System.out.println("Вы выбрали космическое топливо....");
                }
            }
        }
    }
}
