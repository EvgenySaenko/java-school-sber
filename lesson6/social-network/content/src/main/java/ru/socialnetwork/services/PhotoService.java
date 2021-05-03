package ru.socialnetwork.services;

import ru.socialnetwork.persist.entities.Photo;
import ru.socialnetwork.repositories.PhotoRepositoryImpl;

public class PhotoService {
    private final PhotoRepositoryImpl photoRepository;

    public PhotoService() {
        this.photoRepository = new PhotoRepositoryImpl();
    }

    public Photo getPhotoById(Long id) {
        return photoRepository.getPhotoById(id);
    }
}
