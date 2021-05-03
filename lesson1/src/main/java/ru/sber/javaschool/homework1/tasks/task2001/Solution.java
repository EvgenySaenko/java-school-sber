package ru.sber.javaschool.homework1.tasks.task2001;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean active = true;
        int a = 0;
        int b = 0;
        while (active) {
            a = sc.nextInt();
            b = sc.nextInt();
            active = false;
        }
        int sum = a + b;
        System.out.print(sum);
    }
}
