package ru.sber.javaschool.homeworks.tasks.task2023.solution1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sizeArrayA = sc.nextInt();
        Integer[] arrayA = new Integer[sizeArrayA];
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = sc.nextInt();
        }

        int sizeArrayB = sc.nextInt();
        Integer[] arrayB = new Integer[sizeArrayB];
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = sc.nextInt();
        }

        List<Integer> first = Arrays.asList(arrayA);
        List<Integer> second = Arrays.asList(arrayB);
        Collection<Integer> same = new ArrayList<>(first);
        same.retainAll(second);

        Integer[] arrayC = new Integer[same.size()];
        arrayC = same.toArray(arrayC);

        if (arrayC.length == 0) {
            System.out.println(0);
        } else {
            System.out.print(arrayC.length + "\n");
            for (int i = 0; i < arrayC.length; i++) {
                System.out.print(arrayC[i] + " ");
            }
        }
    }
}
