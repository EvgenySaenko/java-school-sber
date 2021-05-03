package ru.socialnetwork.repositories;

import ru.socialnetwork.persist.entities.SocialMediaWall;

public interface SocialMediaWallRepository {

    SocialMediaWall getWallById(Long id);
}
