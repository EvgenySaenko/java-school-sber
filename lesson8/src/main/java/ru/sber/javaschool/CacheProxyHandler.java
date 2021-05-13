package ru.sber.javaschool;


import sun.misc.LRUCache;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CacheProxyHandler implements InvocationHandler {

    private Map<Object, Object> lruCache;

    private final Object original;

    private final Path cacheDirectory;

    private int maxCapacity;


    public CacheProxyHandler(Object proxyCandidate, int maxCapacity, Path cacheDirectory) {
        this.maxCapacity = maxCapacity;
        this.original = proxyCandidate;
        this.cacheDirectory = cacheDirectory;
        initLruCache();
    }

    public void initLruCache() {
        this.lruCache = new LinkedHashMap<Object, Object>(maxCapacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
                return size() > maxCapacity;
            }
        };
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Cache.class)) return invokeOriginal(method, args);
        if (method.getAnnotation(Cache.class).cacheType().equals(Cache.Type.IN_MEMORY)) {//если указан тим в памяти
            if (!lruCache.containsKey(key(method, args))) {//используем нашу мапу
                Object resultValue = invokeOriginal(method, args);//получили результат
                lruCache.put(key(method, args), resultValue);//закинули в мапу
            }
            //lruCache.forEach((k,v) -> System.out.println("key - " + k + " " + "value -" + v));
            return lruCache.get(key(method, args));
        } else {
            if (method.getAnnotation(Cache.class).zip()) {

            }
            //сформируем имя файла [public abstract double ru.sber.javaschool.HardService.doHardWork(java.lang.String,double), work1, 3.5]
            String fileName = key(method, args).toString() + ".txt";
            if (Files.exists(Paths.get(cacheDirectory + "\\" + fileName))) {
                //если такой файл есть => достали результат и вернули
                double result = (double) deserializeDataFromFile(fileName);
                return result;
            }
            Object resultValue = invokeOriginal(method, args);//получим результат
            boolean zip = method.getAnnotation(Cache.class).zip();//узнаем надо ли сжимать файл
            serializeDataToFile(fileName, resultValue,zip);//кладем имя файла и результат
            return resultValue;
        }
    }

    //вызываем метод оригинала
    private Object invokeOriginal(Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(original, args);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Ошибка при вызове оригинального метода", e);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    //кладем в качестве ключа список - [метод и его аргументы]
    private Object key(Method method, Object[] args) {
        List<Object> key = new ArrayList<>();
        key.add(method);//[public abstract double ru.sber.javaschool.HardService.doHardWork(java.lang.String,double)]
        key.addAll(Arrays.asList(args));//[work1, 3.5]
        return key;//[public abstract double ru.sber.javaschool.HardService.doHardWork(java.lang.String,double), work1, 3.5]
    }

    private void serializeDataToFile(String fileName, Object resultValue, boolean zip) {
        //формируем полный путь с именем файла
        Path fullFileNamePath = Paths.get(cacheDirectory + "\\" + fileName);
        if (zip){
            try (FileOutputStream fos = new FileOutputStream(fullFileNamePath.toString());
                 GZIPOutputStream gzos =  new GZIPOutputStream(fos);
                 ObjectOutputStream oos = new ObjectOutputStream(gzos)) {
                oos.writeObject(resultValue);//пишем в файл результат
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileOutputStream fos = new FileOutputStream(fullFileNamePath.toString());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(resultValue);//пишем в файл результат
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object deserializeDataFromFile(String fileName) {
        //формируем полный путь с именем файла
        Path fullFileNamePath = Paths.get(cacheDirectory + "\\" + fileName);

        Object result = null;
        try (FileInputStream fis = new FileInputStream(fullFileNamePath.toString());
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}
