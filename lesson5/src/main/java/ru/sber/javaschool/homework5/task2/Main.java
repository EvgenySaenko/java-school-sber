package ru.sber.javaschool.homework5.task2;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Figure square =  new Square(5f,5f);
        square.getPerimeter();
        square.getArea();

        //вывести на консоль все методы класса включая все родительские
        allMethodsClass(square);
    }

    private static void allMethodsClass(Object obj){
        if (obj == null){
            throw new RuntimeException("Объект не проинициализирован!");
        }
        Class<?> clazz = obj.getClass();//square

        Class<?> superClazz = clazz.getSuperclass();//figure

        Method[] methodsSuper =  superClazz.getDeclaredMethods();//все методы public figure + унаследованые

        Method[] methodsClass =  clazz.getDeclaredMethods();//все методы public square + унаследованые

        Method[] allMethods = new Method[methodsClass.length + methodsSuper.length];
        System.arraycopy(methodsSuper,0,allMethods,0,methodsSuper.length);
        System.arraycopy(methodsClass,0,allMethods,methodsSuper.length,methodsClass.length);

        for (int i = 0; i < allMethods.length; i++) {
            System.out.println(allMethods[i]);
        }



    }
}
