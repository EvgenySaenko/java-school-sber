package ru.sber.javaschool.homework3.task2;

import java.util.ArrayList;
import java.util.List;


//2.	Параметризовать методы, используя правило PECS, и реализовать их.
public class CollectionUtils {
    public static<T> void addAll( List<? super T> destination, List<? extends T> source) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> T indexOf(List<? extends T> source, T o) {
        if (source == null || o == null){
            throw new NullPointerException("Не проинициализированный источник данных");
        }else{
            return source.get((Integer) o);
        }
    }

//    public static <T> List<T> limit(List<? extends T> source, T size) {
//        if (source == null || size == null){
//            throw new NullPointerException("Не проинициализированный источник данных");
//        }else{
//
//        }
//    }

    public static <T> void add(List<? super T> source, T o) {
        if (source == null || o == null){
            throw new NullPointerException("Не проинициализированный источник данных");
        }else{
            source.add(o);
        }
    }
    //Если мы объявили <? extends T>, то это producer. Он только «продюсирует», предоставляет элемент из контейнера,
    // а сам ничего не принимает.
    //Если же мы объявили <? super T> — то это consumer. Он только принимает, а предоставить ничего не может.
    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T>  c2) {
        if (removeFrom == null || c2 == null){
            throw new NullPointerException("Не проинициализированный источник данных");
        }else{
            removeFrom.removeAll(c2);
        }
    }

    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<? super T> dest, List<? extends T> src) {
        if (dest == null || src == null){
            throw new NullPointerException("Не проинициализированный источник данных");
        }else{
            return dest.containsAll(src);
        }
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List<? super T> dest, List<? extends T> src) {
        if (dest == null || src == null){
            throw new NullPointerException("Не проинициализированный источник данных");
        }else{
            dest.retainAll(src);
            System.out.println(dest + " пересечения");
            return dest.size() > 0;
        }
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
//    public static <T extends Comparable<? super T>> List<T> range(List <? extends T > list, T min, T max) {
//
//    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}

//    public static <T> List <T> range(List <? extends T > list, T min, T max, Comparator <T> comparator) {
//
//    }

}

