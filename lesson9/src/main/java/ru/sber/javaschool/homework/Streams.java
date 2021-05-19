package ru.sber.javaschool.homework;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams<T> {
    private Collection <T> collection;


    //todo под вопросом - **После выполнения всех операций коллекция someCollection не должна поменяться.**
    public Streams(Collection<T> collection) {
        this.collection = collection;
    }

    public static <T> Streams<T> of(T... values) {
        return new Streams<>(Arrays.asList(values)) ;
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        Iterator<T> it = collection.iterator();
        while (it.hasNext()){
            if (!predicate.test(it.next())){
                collection.remove(it.next());
            }
        }
        return this;
    }

    public Streams<T> transform(Function<T, Integer> function) {
       collection.forEach(function::apply);
        return this;
    }

//    public Map toMap() {
//
//    }
}

