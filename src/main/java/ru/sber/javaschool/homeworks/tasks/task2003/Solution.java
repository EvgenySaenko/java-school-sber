package ru.sber.javaschool.homeworks.tasks.task2003;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean positive = false;
        int count = sc.nextInt();
        int alternativeAmount = 0;
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                alternativeAmount += sc.nextInt();
            } else if (!positive) {
                alternativeAmount -= sc.nextInt();
                positive = true;
            } else {
                alternativeAmount += sc.nextInt();
                positive = false;
            }
        }
        System.out.print(alternativeAmount);
    }
}
