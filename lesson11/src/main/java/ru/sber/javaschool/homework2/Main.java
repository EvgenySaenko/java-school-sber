package ru.sber.javaschool.homework2;




import java.util.Scanner;

public class Main {
    public static void welcome() {
        System.out.println("АИ-92: 1\nАИ-95: 2\nАИ-100: 3 ");
        System.out.print("Выберите марку бензина: ");
    }

    public static void main(String[] args) {
        FixedThreadPool pool =  new FixedThreadPool(4);
        pool.execute(new Task("АИ-95", 1));
        pool.execute(new Task("АИ-95", 2));
        pool.execute(new Task("АИ-95", 3));
//        pool.execute(new Task("АИ-95", 4));
//        pool.execute(new Task("АИ-92", 6));
//        pool.execute(new Task("АИ-92", 7));
        pool.start();
//        pool.execute(new Task("АИ-95", 4));
//        pool.execute(new Task("АИ-95", 5));
        //pool.shutdownAll();
        fuelFilling(pool);

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
                        pool.execute(new Task("АИ-92", count));
                    }
                }
                if (number == 2) {
                    System.out.println("Вы выбрали АИ-95");
                    System.out.print("Введите количество литров: ");

                    if (sc.hasNext()) {
                        int count = sc.nextInt();
                        pool.execute(new Task("АИ-95", count));
                    }
                }
                if (number == 3){
                    System.out.println("Вы выбрали космическое топливо....");
                }
            }
        }
    }
}
