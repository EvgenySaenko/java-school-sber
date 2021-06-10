package ru.sber.javaschool.refactoring;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Tractor tractor = new Tractor();

        String s = "";
        System.out.println("Нажмите кнопку:");
        while (sc.hasNext()){
            s = sc.next();
            tractor.move(s);
            System.out.println("Нажата : " + s);
        }
    }
}
