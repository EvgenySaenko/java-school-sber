package ru.sber.javaschool.repositories;

import org.springframework.stereotype.Repository;
import ru.sber.javaschool.entity.Urls;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DownloadRepository{
    private Map<Long,Urls> urls;


    @PostConstruct
    public void init(){
        this.urls =  new ConcurrentHashMap<>();
        this.urls.put(1L,new Urls(1L,"Рингтон Ershov & Kagramanov - Заплетай","https://namobilu.com/download/ringtones/mps/216208"));
        this.urls.put(2L,new Urls(2L,"Рингтон Cut Off - All I Want","https://namobilu.com/download/ringtones/mps/220402"));
        this.urls.put(3L,new Urls(3L,"Рингтон Мари Краймбрери & Alex Davia - If You Love Me","https://namobilu.com/download/ringtones/mps/216929"));
        this.urls.put(4L,new Urls(4L,"Рингтон BROHM - In The End","https://namobilu.com/download/ringtones/mps/216349"));
        this.urls.put(5L,new Urls(5L,"Рингтон relaiXX - Farah","https://namobilu.com/download/ringtones/mps/217762"));
        this.urls.put(6L,new Urls(6L,"Рингтон Tiesto - The Business (JONVS Remix)","https://namobilu.com/download/ringtones/mps/216033"));
        this.urls.put(7L,new Urls(7L,"woman_standing_on_a_hill","https://www.wallpaperbetter.com/ru/hd-wallpaper-zramc/download/1920x1080"));
        this.urls.put(8L,new Urls(8L,"two_people","https://www.wallpaperbetter.com/ru/hd-wallpaper-fvmtu/download/1280x720"));
    }

    public Collection<Urls> getUrls(){
        return this.urls.values();
    }

    public List<Urls> getListUrlById(List<Long> urlId){
        List<Urls> returnList =  new ArrayList<>();
        for (Long aLong : urlId) {
            if (urls.containsKey(aLong)) {
                returnList.add(urls.get(aLong));
            }
        }
        return returnList;
    }

}
