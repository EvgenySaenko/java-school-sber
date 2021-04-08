package ru.sber.javaschool.homeworks.tasks.task2026;

import java.util.Scanner;

public class Solution {//все работает, но сайт не принемает(((
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        int max = array[0];
        int[] copy = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (max < array[j]) {
                    max = array[j];
                    copy[i] = max;
                    break;
                }
            }
            if (i < array.length - 2) {
                max = array[i + 1];
            }
        }
        for (int j = 0; j < copy.length; j++) {
            System.out.print(copy[j] + " ");
        }
    }
}
