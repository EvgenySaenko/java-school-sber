package ru.sber.javaschool.iterator;


public class Main {
    public static void main(String[] args) {

        Cat[] cats = {
                new Cat(1,"Bob"),
                new Cat(2,"Murzik"),
                new Cat(5, "Vaska")
        };

        MyArrayObjectsIterator<Cat> it =  new MyArraysIterator<>(cats);

        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
