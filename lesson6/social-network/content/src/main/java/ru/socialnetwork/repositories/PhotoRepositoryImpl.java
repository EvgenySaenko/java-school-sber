package ru.socialnetwork.repositories;

import ru.socialnetwork.persist.entities.Photo;

import java.util.HashMap;
import java.util.Map;

public class PhotoRepositoryImpl implements PhotoRepository{

    private Map<Long,Photo> mapPhoto;

    public PhotoRepositoryImpl() {
        initPhoto();
    }

    public void initPhoto(){
        this.mapPhoto =  new HashMap<>();
        mapPhoto.put(1L,new Photo(1L,"описание1"));
        mapPhoto.put(2L,new Photo(2L,"описание2"));
        mapPhoto.put(3L,new Photo(3L,"описание3"));
        mapPhoto.put(4L,new Photo(4L,"описание4"));
        mapPhoto.put(5L,new Photo(5L,"описание5"));
        mapPhoto.put(6L,new Photo(6L,"описание6"));
        mapPhoto.put(7L,new Photo(7L,"описание7"));
    }

    @Override
    public Photo getPhotoById(Long id) {
        return mapPhoto.get(id);
    }
}
