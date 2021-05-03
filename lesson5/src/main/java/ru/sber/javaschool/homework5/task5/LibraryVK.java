package ru.sber.javaschool.homework5.task5;


public interface LibraryVK {
    @Cache
    Photo getPhoto(String id);
}
