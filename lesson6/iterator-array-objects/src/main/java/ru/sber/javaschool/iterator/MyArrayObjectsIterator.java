package ru.sber.javaschool.iterator;

import java.util.Iterator;

public interface MyArrayObjectsIterator<T> extends Iterator {
    boolean hasNext();
    T next();
    void remove();
}
