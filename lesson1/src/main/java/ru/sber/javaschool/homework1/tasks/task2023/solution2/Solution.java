package ru.sber.javaschool.homework1.tasks.task2023.solution2;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lineNumber = "";

        int sizeArrayA = sc.nextInt();
        int[] arrayA = new int[sizeArrayA];
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = sc.nextInt();
        }

        int sizeArrayB = sc.nextInt();
        int[] arrayB = new int[sizeArrayB];
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = sc.nextInt();
        }

        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] == arrayB[j]) {
                    lineNumber += arrayA[i] + " ";
                    break;
                }
            }
        }
        int[] arrayC;
        String[] arrString;
        if (lineNumber.equals("")) {
            arrayC = new int[0];
            System.out.print("0");
        } else {
            arrString = lineNumber.split(" ");
            arrayC = new int[arrString.length];
            System.out.print(arrayC.length + "\n");
            for (int i = 0; i < arrayC.length; i++) {
                arrayC[i] = Integer.parseInt(arrString[i]);
                System.out.print(arrayC[i]);
            }
        }
    }
}
