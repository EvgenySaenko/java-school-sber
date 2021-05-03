package ru.socialnetwork.repositories;

import ru.socialnetwork.persist.entities.Photo;

public interface PhotoRepository {

    Photo getPhotoById(Long id);
}
