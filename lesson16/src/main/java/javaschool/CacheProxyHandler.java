package javaschool;


import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

//todo рефакторинг, спец класс который по длинному названию будет генерить имя файла(uuid) ,
// при переполнении concurrentHashMap настроить механизм вытеснения старого кеша(своя реализация коллекции или что то другое)(guava)
public class CacheProxyHandler implements InvocationHandler {

    private Map<Object, Object> lruCache;
    private final Object original;
    private final Path cacheDirectory;
    private final int maxCapacity;

    public CacheProxyHandler(Object proxyCandidate, int maxCapacity, Path cacheDirectory) {
        this.maxCapacity = maxCapacity;
        this.original = proxyCandidate;
        this.cacheDirectory = cacheDirectory;
        initLruCache();
    }

    public void initLruCache() {//самый первый который попал в кэш считаем самым старым => будет вылетать при переполненнии кеша
        //concurrencyLevel - уровень параллелизма - ставят равный количеству потоков одновременно работающих с коллекцией
        this.lruCache =  new ConcurrentHashMap<>(maxCapacity,0.75f,16);

//        this.lruCache = new LinkedHashMap<Object, Object>(maxCapacity, 0.75f, true) {
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
//                System.out.println("size = " + size() + "maxCapacity = " + maxCapacity);
//                return size() > maxCapacity;
//            }
//        };
    }

    @Override
    public synchronized Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Cache.class)) return invokeOriginal(method, args);
        if (method.getAnnotation(Cache.class).cacheType().equals(Cache.Type.IN_MEMORY)) {//если указан тим в памяти
            if (!lruCache.containsKey(key(method, args))) {//используем нашу мапу
                Object resultValue = invokeOriginal(method, args);//получили результат
                lruCache.put(key(method, args), resultValue);//закинули в мапу
            }
            lruCache.forEach((k,v) -> System.out.println("key - " + k + " " + "value -" + v));
            return lruCache.get(key(method, args));
        } else {//если FILE
            //сформируем имя файла [doHardWorkForFile, [class java.lang.String, class java.lang.String], class java.lang.String, copyPast8, HappyNewYear]
            String fileName = key(method, args).toString() + ".txt";
            String fileNameZipFile = key(method, args).toString() + ".zip";
            if (Files.exists(Paths.get(cacheDirectory + "\\" + fileName))) {//ищет не сжатые файлы
                //если такой файл есть => достали результат и вернули
                return deserializeDataFromFileNoZip(fileName);
            }
            if (Files.exists(Paths.get(cacheDirectory + "\\" + fileNameZipFile))) {//ищет сжатые файлы
                //если такой файл есть => достали результат и вернули
                return deserializeDataFromFileZip(fileNameZipFile);
            }
            if (method.getAnnotation(Cache.class).zip()) {//если указали => сжать файл
                Object resultValue = invokeOriginal(method, args);
                serializeDataToFileZip(fileName, resultValue);
            }
            Object resultValue = invokeOriginal(method, args);//получим результат
            serializeDataToFileNoZip(fileName, resultValue);//кладем имя файла и результат
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
        //method = [public abstract double ru.sber.javaschool.HardService.doHardWork(java.lang.String,double)]
        List<Object> key = new ArrayList<>();
        key.add(method.getName());//doHardWorkForFile -название метода
        key.add(Arrays.toString(method.getParameterTypes()));//[class java.lang.String, class java.lang.String] - типы аргументов
        key.add(method.getReturnType());//class java.lang.String - возвращаемый тип
        key.addAll(Arrays.asList(args));//[work1, 3.5] - аргументы метода
        System.out.println(key);
        return key;//[doHardWorkForFile, [class java.lang.String, class java.lang.String], class java.lang.String, copyPast8, HappyNewYear]
    }

    private  void serializeDataToFileNoZip(String fileName, Object resultValue) {
        //формируем полный путь с именем файла
        Path fullFileNamePath = Paths.get(cacheDirectory + "\\" + fileName);
        try (FileOutputStream fos = new FileOutputStream(fullFileNamePath.toString());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(resultValue);//пишем в файл результат
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  Object deserializeDataFromFileNoZip(String fileName) {
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

    private  void serializeDataToFileZip(String fileName, Object resultValue){
        Path fullFileNamePath = Paths.get(cacheDirectory + "\\" + fileName);
        try (FileOutputStream fos = new FileOutputStream(fullFileNamePath.toString() + ".zip");
             GZIPOutputStream gzos =  new GZIPOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(gzos)) {
            oos.writeObject(resultValue);//пишем в файл результат
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  Object deserializeDataFromFileZip(String fileName) {
        //формируем полный путь с именем файла
        Path fullFileNamePath = Paths.get(cacheDirectory + "\\" + fileName);

        Object result = null;
        try (FileInputStream fis = new FileInputStream(fullFileNamePath.toString());
             GZIPInputStream gzis =  new GZIPInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(gzis)) {
            result = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}
