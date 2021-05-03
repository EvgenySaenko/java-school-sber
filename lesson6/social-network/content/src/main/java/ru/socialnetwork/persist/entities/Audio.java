package ru.socialnetwork.persist.entities;


import java.util.Objects;

public class Audio {

    private Long id;

    private String name;

    private String singer;

    public Audio(Long id, String name, String singer) {
        this.id = id;
        this.name = name;
        this.singer = singer;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audio audio = (Audio) o;
        return Objects.equals(id, audio.id) && Objects.equals(name, audio.name) && Objects.equals(singer, audio.singer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, singer);
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }
}
