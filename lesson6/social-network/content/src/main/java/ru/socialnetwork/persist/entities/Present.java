package ru.socialnetwork.persist.entities;

import java.util.Objects;

public class Present {
    private Long id;

    private String name;

    private String title;

    public Present(Long id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Present present = (Present) o;
        return Objects.equals(id, present.id) && Objects.equals(name, present.name) && Objects.equals(title, present.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, title);
    }

    @Override
    public String toString() {
        return "Present{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
