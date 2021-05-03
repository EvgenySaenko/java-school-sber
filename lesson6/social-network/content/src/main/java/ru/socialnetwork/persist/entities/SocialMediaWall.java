package ru.socialnetwork.persist.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class SocialMediaWall {

    private Long id;

    private List<Post> posts;

    private Calendar datePost;

    public SocialMediaWall(Long id, List<Post> posts, Calendar datePost) {
        this.id = id;
        this.posts = posts;
        this.datePost = datePost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Calendar getDatePost() {
        return datePost;
    }

    public void setDatePost(Calendar datePost) {
        this.datePost = datePost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialMediaWall that = (SocialMediaWall) o;
        return Objects.equals(id, that.id) && Objects.equals(posts, that.posts) && Objects.equals(datePost, that.datePost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, posts, datePost);
    }

    @Override
    public String toString() {
        return "SocialMediaWall{" +
                "id=" + id +
                ", posts=" + posts +
                ", datePost=" + new SimpleDateFormat("yyyy-MM-dd").format(datePost.getTime()) +
                '}';
    }
}
