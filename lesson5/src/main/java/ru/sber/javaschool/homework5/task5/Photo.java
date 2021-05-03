package ru.sber.javaschool.homework5.task5;

import java.util.Objects;

public class Photo {
    private String id;
    private String name;

    public Photo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(id, photo.id) && Objects.equals(name, photo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Photo[id: " + id + "," + " name: " + name + "]";
    }
}
