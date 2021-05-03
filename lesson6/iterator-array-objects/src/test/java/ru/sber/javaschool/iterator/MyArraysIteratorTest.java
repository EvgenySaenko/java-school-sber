package ru.sber.javaschool.iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyArraysIteratorTest {

    private Cat[] catsFull;
    private Cat[] catsEmpty;
    private MyArrayObjectsIterator<Cat> itFull;
    private MyArrayObjectsIterator<Cat> itEmpty;

    @Before
    public void initFull() {
        this.catsFull = new Cat[3];
        catsFull[0] = new Cat(3, "Murzik");
        catsFull[1] = new Cat(5, "Barsik");
        catsFull[2] = new Cat(7, "Lolo");
        this.itFull = new MyArraysIterator<>(catsFull);

        this.catsEmpty = new Cat[0];
        this.itEmpty = new MyArraysIterator<>(catsEmpty);
    }

    @Test
    public void hasNextArrayEmpty() {
        Assert.assertFalse(itEmpty.hasNext());
    }

    @Test
    public void hasNextArrayFull() {
        Assert.assertTrue(itFull.hasNext());
    }


    @Test
    public void nextFull() {
        while (itFull.hasNext()) {
            Assert.assertEquals(new Cat(3, "Murzik"), itFull.next());
            Assert.assertEquals(new Cat(5, "Barsik"), itFull.next());
            Assert.assertEquals(new Cat(7, "Lolo"), itFull.next());
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void nextEmpty() {
        Assert.assertEquals(new Cat(3, "Murzik"), itEmpty.next());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        itFull.remove();
        itEmpty.remove();
    }
}