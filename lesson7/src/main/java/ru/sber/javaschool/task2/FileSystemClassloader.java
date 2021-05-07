package ru.sber.javaschool.task2;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemClassloader extends ClassLoader {

    private String rootDir;

    public FileSystemClassloader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(className);// Посмотрим, был ли загружен этот класс
        if (c != null) {// уже загружен
            return c;
        } else {// Пусть родительский класс AppClassLoader загружается
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(className);// Делегируется родительскому классу для загрузки
            } catch (ClassNotFoundException e) {
                // System.out.println («Родительский класс не может загрузить ваш класс,
                // выдать исключение ClassNotFoundException, перехвачен, продолжить работу»);
            }
            if (c != null) {// родительский класс загружен успешно
                System.out.println("Родительский класс загружен успешно");
                return c;
            } else {// Чтение файла в байтовый массив
                byte[] classData = getClassData(className);
                if (classData == null) {
                    throw new ClassNotFoundException();// вручную генерируем выгруженное исключение
                } else {
                    c = defineClass(className, classData, 0, classData.length);
                    return c;
                }
            }
        }
    }

    private byte[] getClassData(String className) {
        String path = rootDir + "/" + className.replace('.', '/') + ".class";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int temp = 0;
            while ((temp = is.read(buffer)) != -1) {// чтение из входного потока
                baos.write(buffer, 0, temp);// положить байтовый массив
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {// Закрыть входной поток поток байтового массива
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
