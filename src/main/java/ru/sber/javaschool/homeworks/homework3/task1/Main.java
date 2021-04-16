package ru.sber.javaschool.homeworks.homework3.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void showCountMapImpl(CountMapImpl<String, Integer> map){
        Set<Map.Entry<String,Integer>> set =  map.toMap().entrySet();
        for (Map.Entry<String,Integer> entry: set){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void showMap(Map<String, Integer> map){
        Set<Map.Entry<String,Integer>> set =  map.entrySet();
        for (Map.Entry<String,Integer> entry: set){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        CountMapImpl<String,Integer> map = new CountMapImpl<>();
        map.add("A");
        map.add("B");
        map.add("C");
        map.add("B");
        map.add("A");
        map.add("A");
        map.add("D");


        showCountMapImpl(map);
        System.out.println("=============");
        map.add("A");
        showCountMapImpl(map);
        System.out.println("=============");
        System.out.println("элементов до удаления - " + map.size());
        System.out.println("количество добавлений до удаления => " + map.remove("A"));
        System.out.println("элементов после удаления - " + map.size());
        showCountMapImpl(map);
        System.out.println("=============");
        System.out.println("количество добавлений элемента B => " + map.getCount("B"));

        System.out.println("=============");
        System.out.println("Начальное состояние: map");
        showCountMapImpl(map);
        System.out.println("=============");

        //создадим копию этой мапы
        CountMapImpl<String,Integer> map2 = new CountMapImpl<>();
        map2.add("B");
        map2.add("B");
        map2.add("C");
        map2.add("A");
        System.out.println("Начальное состояние: map2");
        showCountMapImpl(map2);
        System.out.println("=============");
        System.out.println("map после добавления в нее map2");
        map.addAll(map2);
        showCountMapImpl(map);
        System.out.println("=============");


        Map<String,Integer> mapDest =  new HashMap<>();
        showMap(mapDest);
        System.out.println(mapDest.size());
        System.out.println("=============");
        map.toMap(mapDest);//пишем инфу в destination
        showMap(mapDest);
        System.out.println(mapDest.size());
    }
}
