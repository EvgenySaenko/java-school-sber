package ru.sber.javaschool.homeworks.homework5.task5;


public interface LibraryVK {
    @Cache
    Photo getPhoto(String id);
}
