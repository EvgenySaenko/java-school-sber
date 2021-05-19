package ru.sber.javaschool;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/***
 * Дан файл содержащий несколько случайных натуральных чисел от 1 до 50.
 * Необходимо написать многопоточное приложение,  которое параллельно рассчитает и выведет
 * в консоль факториал для каждого числа из файла.
 ***/
public class MultithreadingApp {

    //метод вычитывает числа из файла
    public List<Integer> readNumberFromFile(File file) {
        Scanner scanner = null;
        List<Integer> numbers = new ArrayList<>();
        try {
            scanner = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            numbers.add(i);
        }
        return numbers;
    }

    //правда такой способ дольше, но другим не выведешь большие числа проще
    private BigInteger calculateFactorial(int n) {
        if (n == 0) return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(calculateFactorial(n - 1));
    }


    public static void main(String[] args) {
        File file = new File("F:\\JavaSchoolSber\\java-school-sber\\lesson10\\numbers.txt");
        MultithreadingApp app = new MultithreadingApp();
        List<Integer> numbers = app.readNumberFromFile(file);

        final int THREAD_COUNTS = numbers.size();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNTS);

        for (int i = 0; i < THREAD_COUNTS; i++) {
            int temp = i;
            new Thread(()-> {
                try {
                    System.out.println("Ready " + Thread.currentThread().getName());
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "  Started Calculating");
                    System.out.println("factorial of number " + numbers.get(temp) + " = " + app.calculateFactorial(numbers.get(temp)));
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " END");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}