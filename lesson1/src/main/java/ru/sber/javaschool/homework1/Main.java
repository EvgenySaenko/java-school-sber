package ru.sber.javaschool.homework1;

public class Main {
    public static void main(String[] args) {
        Person maks = new Person(true,"Maks");
        Person mila = new Person(false,"Mila");

        Person jack =  new Person(true, "Jack");
        Person sarah =  new Person(false, "Sarah");

        //проверка бракосочетания однополых
//        maks.marry(maks);
//        mila.marry(sarah);

        //проверка бракосочетания если супруг есть у того кто предлагает
//        jack.setSpouse(mila);
//        mila.setSpouse(jack);
//        jack.marry(sarah);
//        System.out.println(jack.getName() + " есть ли супруг? -> " + jack.isSpouse() + " " + jack.getSpouse().getName());
//        System.out.println(sarah.getName() + " есть ли супруг? -> " + sarah.isSpouse() + " " + sarah.getSpouse().getName());

        //проверка бракосочетания если супруг есть у того кому предлагают
        //mila.setSpouse(jack);
        //jack.setSpouse(mila);//поженили

        maks.marry(mila);//не женатый макс предложил - женатой миле руку и сердце

        //проверка если оба без пары
        mila.setSpouse(jack);
        jack.setSpouse(mila);//поженили

        System.out.println(maks.getName() + " есть ли супруг? -> " + maks.isSpouse() + " " + maks.getSpouse().getName());
        System.out.println(mila.getName() + " есть ли супруг? -> " + mila.isSpouse() + " " + mila.getSpouse().getName());

        //System.out.println(jack.getSpouse().getName());

    }
}
