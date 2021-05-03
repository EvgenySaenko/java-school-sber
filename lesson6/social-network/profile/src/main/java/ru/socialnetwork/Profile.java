package ru.socialnetwork;

import ru.socialnetwork.persist.entities.*;

import java.util.List;
import java.util.Objects;


//профиль может содержать
//- фото и фото альбомы
//- инфо
//- аудио и видео список
//- список групп на которые подписан
//- список друзей
//- стена с постами
public class Profile {
    private Photo photo;

    private Info info;

    private List<Photo> album;

    private List<Audio> music;

    private List<Video> videoList;

    private List<Group> groupList;

    private List<Profile> friends;

    private SocialMediaWall socialMediaWall;

    public Profile(Photo photo, Info info, List<Photo> album, List<Audio> music, List<Video> videoList,
                   List<Group> groupList, List<Profile> friends, SocialMediaWall socialMediaWall) {
        this.photo = photo;
        this.info = info;
        this.album = album;
        this.music = music;
        this.videoList = videoList;
        this.groupList = groupList;
        this.friends = friends;
        this.socialMediaWall = socialMediaWall;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Photo> getAlbum() {
        return album;
    }

    public void setAlbum(List<Photo> album) {
        this.album = album;
    }

    public List<Audio> getMusic() {
        return music;
    }

    public void setMusic(List<Audio> music) {
        this.music = music;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<Profile> getFriends() {
        return friends;
    }

    public void setFriends(List<Profile> friends) {
        this.friends = friends;
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
        Profile profile = (Profile) o;
        return Objects.equals(photo, profile.photo) && Objects.equals(info, profile.info) && Objects.equals(album, profile.album) && Objects.equals(music, profile.music) && Objects.equals(videoList, profile.videoList) && Objects.equals(groupList, profile.groupList) && Objects.equals(friends, profile.friends) && Objects.equals(socialMediaWall, profile.socialMediaWall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photo, info, album, music, videoList, groupList, friends, socialMediaWall);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "photo=" + photo +
                ", info=" + info +
                ", album=" + album +
                ", music=" + music +
                ", videoList=" + videoList +
                ", groupList=" + groupList +
                ", friends=" + friends +
                ", socialMediaWall=" + socialMediaWall +
                '}';
    }
}
