package ru.socialnetwork;

import ru.socialnetwork.persist.entities.Photo;
import ru.socialnetwork.persist.entities.SocialMediaWall;

import java.util.List;
import java.util.Objects;


//группа может содержать фото, фотоальбомы, описание, список подписчиков , стена с постами итд, не стал добавлять прям все
public class Group {
    private Photo photo;

    private List<Photo> album;

    private String titleGroup;

    private List<Profile> subscribers;

    private SocialMediaWall socialMediaWall;

    public Group(Photo photo, List<Photo> album, String titleGroup, List<Profile> subscribers, SocialMediaWall socialMediaWall) {
        this.photo = photo;
        this.album = album;
        this.titleGroup = titleGroup;
        this.subscribers = subscribers;
        this.socialMediaWall = socialMediaWall;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public List<Photo> getAlbum() {
        return album;
    }

    public void setAlbum(List<Photo> album) {
        this.album = album;
    }

    public String getTitleGroup() {
        return titleGroup;
    }

    public void setTitleGroup(String titleGroup) {
        this.titleGroup = titleGroup;
    }

    public List<Profile> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Profile> subscribers) {
        this.subscribers = subscribers;
    }

    public SocialMediaWall getSocialMediaWall() {
        return socialMediaWall;
    }

    public void setSocialMediaWall(SocialMediaWall socialMediaWall) {
        this.socialMediaWall = socialMediaWall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(photo, group.photo) && Objects.equals(album, group.album) && Objects.equals(titleGroup, group.titleGroup) && Objects.equals(subscribers, group.subscribers) && Objects.equals(socialMediaWall, group.socialMediaWall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photo, album, titleGroup, subscribers, socialMediaWall);
    }

    @Override
    public String toString() {
        return "Group{" +
                "photo=" + photo +
                ", album=" + album +
                ", titleGroup='" + titleGroup + '\'' +
                ", subscribers=" + subscribers +
                ", socialMediaWall=" + socialMediaWall +
                '}';
    }
}
