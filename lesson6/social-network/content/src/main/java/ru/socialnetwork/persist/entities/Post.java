package ru.socialnetwork.persist.entities;

import java.util.Objects;

public class Post {
    private Long id;

    private String title;

    private String content;

    private Image image;

    private Photo photo;

    private Audio audio;

    private Video video;

    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Post(Long id, String title, String content, Image image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public Post(Long id, String title, String content, Photo photo) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.photo = photo;
    }

    public Post(Long id, String title, String content, Video video) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.video = video;
    }

    public Post(Long id, String title, String content, Image image, Audio audio) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.audio = audio;
    }

    public Post(Long id, String title, String content, Photo photo, Audio audio) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.photo = photo;
        this.audio = audio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(content, post.content) && Objects.equals(image, post.image) && Objects.equals(photo, post.photo) && Objects.equals(audio, post.audio) && Objects.equals(video, post.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, image, photo, audio, video);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image=" + image +
                ", photo=" + photo +
                ", audio=" + audio +
                ", video=" + video +
                '}';
    }
}
