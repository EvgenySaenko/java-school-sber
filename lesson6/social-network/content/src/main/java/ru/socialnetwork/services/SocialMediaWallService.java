package ru.socialnetwork.services;

import ru.socialnetwork.persist.entities.SocialMediaWall;
import ru.socialnetwork.repositories.SocialMediaWallRepositoryImpl;

public class SocialMediaWallService {

    private SocialMediaWallRepositoryImpl socialMediaWallRepository;

    public SocialMediaWallService() {
        this.socialMediaWallRepository = new SocialMediaWallRepositoryImpl();
    }

    public SocialMediaWall getWallById(Long id) {
        return socialMediaWallRepository.getWallById(id);
    }
}
