package ru.sber.javaschool.homeworks.homework1.tasks.task2004;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
