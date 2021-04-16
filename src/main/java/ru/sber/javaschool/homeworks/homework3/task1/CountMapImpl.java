package ru.sber.javaschool.homeworks.homework3.task1;


import java.util.*;

public class CountMapImpl<K,V extends Integer> implements CountMap<K, Integer> {

    private Map<K, Integer> map;

    public CountMapImpl() {
        this.map = new HashMap<>();
    }

    @Override// добавляет элемент в этот контейнер.
    public void add(K key) {
        if (!map.containsKey(key)){
            map.put(key, 1);
        }else if (map.containsKey(key)){
            int value = map.get(key);
            map.put(key, value + 1);
        }
    }

    @Override//Возвращает количество добавлений данного элемента
    public Integer getCount(K key) {
        if (!map.containsKey(key)){
            return 0;
        }
        return map.get(key);
    }

    @Override //Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
    public Integer remove(K key) {
        int value = 0;
        if (!map.containsKey(key)){
            return value;
        }else if (map.containsKey(key)){
            value =  map.get(key);
            map.remove(key);
        }
        return value;
    }

    @Override//количество разных элементов
    public Integer size() {
        return map.size();
    }

    //Добавить все элементы из source в текущий контейнер,
    // при совпадении ключей,     суммировать значения
    @Override
    public void addAll(CountMap<K, Integer> source) {
        Map<K, Integer> sourceMap = source.toMap();
        Set<Map.Entry<K,Integer>> set = sourceMap.entrySet();
        for (Map.Entry<K,Integer> entry: set){
            if (!map.containsKey(entry.getKey())){//если такого ключа в мапе не оказалось
                map.put(entry.getKey(), entry.getValue());//кладем ключ, и их количество в той мапе
            }else if (map.containsKey(entry.getKey())){//если есть ключ
                map.put(entry.getKey(), map.get(entry.getKey()) + entry.getValue());//складываем наше value с value той мапы
            }
        }
    }

    //Вернуть java.util.Map. ключ - добавленный элемент,
    // значение - количество его добавлений
    @Override
    public Map<K, Integer> toMap() {
        return this.map;
    }

    @Override//Тот же самый контракт как и toMap(), только всю информацию записать в destination
    public void toMap(Map<K, Integer> destination) {
        destination.putAll(map);
    }
}
