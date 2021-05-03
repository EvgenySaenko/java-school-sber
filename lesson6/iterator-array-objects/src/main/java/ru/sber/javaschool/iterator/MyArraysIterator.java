package ru.sber.javaschool.iterator;

import java.util.NoSuchElementException;

public class MyArraysIterator<T> implements MyArrayObjectsIterator<T>{

    private int count = 0;
    private int index = 0;
    private T [] array;

    public MyArraysIterator(final T[] array){
        this.array = array;
        this.count = array.length;
    }

    @Override
    public boolean hasNext() {
        return index < count;
    }

    @Override
    public T next() {
        if (index < count) {
            return array[index++];
        } else {
            throw new NoSuchElementException("No such element.");
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove item from array");
    }

}
