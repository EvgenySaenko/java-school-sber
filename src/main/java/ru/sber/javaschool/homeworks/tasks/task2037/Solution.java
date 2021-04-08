package ru.sber.javaschool.homeworks.tasks.task2037;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        String str = sc.nextLine();
        str = str.toLowerCase();
        if (str.length() > 1000) {
            System.exit(1);
        } else {
            int lengthWord = sc.nextInt();

            String[] arrWord = str.split("\\W");
            for (int i = 0; i < arrWord.length; i++) {
                if (arrWord[i] != null && !arrWord[i].trim().isEmpty()) {
                    if (arrWord[i].length() >= lengthWord) {
                        if (count == 0) {
                            System.out.print(arrWord[i]);
                            count++;
                        } else {
                            System.out.print("," + arrWord[i]);
                        }
                    }
                }
            }
        }
    }
}
