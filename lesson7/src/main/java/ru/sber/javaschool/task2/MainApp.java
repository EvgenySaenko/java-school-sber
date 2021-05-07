package ru.sber.javaschool.task2;

import java.io.File;

public class MainApp {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        String encryptedLocated = "F:\\JavaSchoolSber\\java-school-sber\\lesson7\\encrypted";
        String unencryptedLocated = "F:\\JavaSchoolSber\\java-school-sber\\lesson7\\unencrypted";

        //создали загрузчик с ключем
        EncryptedClassloader encryptionLoader = new EncryptedClassloader(0xff,new File(encryptedLocated));

        //файл из unencrypted => зашифровали => положили в /encrypted/  в виде => Hello.class
        encryptionLoader.encode(new File(unencryptedLocated + "\\" + "Hello.class"),
                                new File(encryptedLocated + "\\" + "Hello.class"));

        Class<?> encryptedClass = encryptionLoader.loadClass("Hello");// Загружаем зашифрованный класс
        System.out.println("Class encryptedClass == " + encryptedClass);


        //находим класс лоадером который шифровал его
        Class<?> classHello = encryptionLoader.findClass("Hello");
        System.out.println("Class findClass == " + classHello.getMethod("sayHello"));

        //Если мы попытаемся выполнить блок кода ниже - загрузив или поискав обычным загрузчиком, то словим ошибку
        //Exception in thread "main" java.lang.ClassFormatError: Incompatible magic value 889275713 in class file Hello
        //FileSystemClassloader loader = new FileSystemClassloader(encryptedLocated);// Загрузчик
        //Class<?> classHello2 = loader.findClass("Hello");// ищем зашифрованный класс обычным загрузчиком
        //или
        //Class<?> classHello2 = loader.loadClass("Hello");// Загружаем зашифрованный класс обычным загрузчиком
        //System.out.println("Class classHello == " + classHello);


        //если создадим другой объект такого же загрузчика
        EncryptedClassloader encryptionLoader2 = new EncryptedClassloader(0xff,new File(encryptedLocated));// расшифровываем загрузчик
        Class<?> classHello3 = encryptionLoader2.loadClass("Hello");// Загружаем зашифрованный класс
        System.out.println("Class classHello3 == " + classHello3.getMethod("sayHello"));
    }
}
