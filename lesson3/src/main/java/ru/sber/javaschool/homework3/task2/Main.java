package ru.sber.javaschool.homework3.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = CollectionUtils.newArrayList();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        System.out.println(intList);
        System.out.println(CollectionUtils.indexOf(intList,0));
        CollectionUtils.addAll(intList,new ArrayList<>(Arrays.asList(5,6,7,8)));
        System.out.println(intList);



    }
}
