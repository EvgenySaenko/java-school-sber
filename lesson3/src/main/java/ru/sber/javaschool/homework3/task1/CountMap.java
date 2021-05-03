package ru.sber.javaschool.homework3.task1;

import java.util.Map;

public interface CountMap <K, Integer> {

    // добавляет элемент в этот контейнер.
    void add(K key);

    //Возвращает количество добавлений данного элемента
    Integer getCount(K key);

    //Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
    Integer remove(K key);

    //количество разных элементов
    Integer size();

    //Добавить все элементы из source в текущий контейнер,
    // при совпадении ключей,     суммировать значения
    void addAll(CountMap <K, Integer> source);

    //Вернуть java.util.Map. ключ - добавленный элемент,
    // значение - количество его добавлений
    Map<K, Integer> toMap();

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map <K, Integer> destination);

}
