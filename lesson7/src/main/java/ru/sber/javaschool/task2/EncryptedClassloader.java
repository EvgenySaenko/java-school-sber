package ru.sber.javaschool.task2;

import java.io.*;

public class EncryptedClassloader extends ClassLoader {
    private final Integer key;
    private final File dir;

    public EncryptedClassloader(Integer key, File dir) {
        this.key = key;
        this.dir = dir;
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
                // System.out.println («Родительский класс не может загрузить ваш класс, выдать исключение ClassNotFoundException, перехвачен, продолжить работу»);
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

    public byte[] getClassData(String className) {
        String path = dir + "/" + className.replace('.', '/') + ".class";
        // Преобразовать данные в потоке в байтовый массив
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int temp = -1;
            while ((temp = is.read()) != -1) {// читаем байт
                baos.write(temp ^ key);// Инвертировать дешифрованный вывод
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
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

    //шифруем
    public  void encode(File src, File dest) {
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)){

            int temp = -1;
            while ((temp = fis.read()) != -1) {// читаем байт
                fos.write(temp ^ key);// Инвертировать вывод
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finish Encoding!");
    }


}

