package ru.sber.javaschool.task1;

public class MainAppFileLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        String directoryClassesLocated = "F:\\JavaSchoolSber\\java-school-sber\\lesson7\\plugin";
        FileSystemClassloader loader = new FileSystemClassloader(directoryClassesLocated);// указываем загрузчику root директорию где начинать искать классы
        Class<?> oneLoadClass = loader.loadClass("ru.sber.javaschool.Hello");// указываем конкретно путь к классу = > Загрузить этот класс
        Class<?> twoLoadClass = loader.loadClass("ru.sber.javaschool.Hello");// Загрузить этот класс
        System.out.println("Класс oneLoadClass ==" + oneLoadClass);
        System.out.println("Класс twoLoadClass == "+ twoLoadClass);
        System.out.println("хэш-код oneLoadClass == " + oneLoadClass.hashCode());
        System.out.println("хэш-код twoLoadClass == " + twoLoadClass.hashCode());
        /*
         * oneLoadClass twoLoadClass - это тот же загрузчик, тот же класс, поэтому это тот же объект
         *
         * Загруженный одним и тем же загрузчиком классов и одним и тем же классом, JVM считается одним и тем же классом
         * Один и тот же класс загружается разными несовместимыми загрузчиками, JVM будет считать его другим классом.
         */
        FileSystemClassloader loader3 = new FileSystemClassloader(directoryClassesLocated);// Изменить другой загрузчик
        Class<?> threeLoadClass = loader3.loadClass("ru.sber.javaschool.Hello");// Загрузить этот класс
        System.out.println("хэш-код threeLoadClass == " + threeLoadClass.hashCode());
    }
}
