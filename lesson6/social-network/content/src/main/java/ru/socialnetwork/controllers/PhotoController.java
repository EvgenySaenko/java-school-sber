package ru.socialnetwork.controllers;

import ru.socialnetwork.persist.entities.Photo;
import ru.socialnetwork.services.PhotoService;

public class PhotoController {
    private final PhotoService photoService;

    public PhotoController() {
        this.photoService = new PhotoService();
    }

    public Photo getPhotoById(Long id) {
        return photoService.getPhotoById(id);
    }

}
