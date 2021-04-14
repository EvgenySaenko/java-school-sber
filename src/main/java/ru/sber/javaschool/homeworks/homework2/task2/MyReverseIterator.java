package ru.sber.javaschool.homeworks.homework2.task2;

import java.util.Iterator;
import java.util.List;

public class MyReverseIterator<T> implements Iterator<T>, Iterable<T> {

    private final List<T> list;//список
    private int position;//позиция

    //инициируем список и указатель ставим в хвост списка
    public MyReverseIterator(List<T> list) {
        this.list = list;
        this.position = list.size() - 1;
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        if (list == null) throw new RuntimeException("iterator is null");
        return position >= 0;
    }

    @Override
    public T next() {
        return list.get(position--);
    }

    @Override
    public String toString() {
        return list + "";
    }

}
