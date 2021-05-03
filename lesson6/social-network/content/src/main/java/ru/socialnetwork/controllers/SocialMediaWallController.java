package ru.socialnetwork.controllers;

import ru.socialnetwork.persist.entities.SocialMediaWall;
import ru.socialnetwork.services.SocialMediaWallService;

public class SocialMediaWallController {
    private SocialMediaWallService socialMediaWallService;

    public SocialMediaWallController( ) {
        this.socialMediaWallService = new SocialMediaWallService();
    }

    public SocialMediaWall getWallById(Long id) {
        return socialMediaWallService.getWallById(id);
    }
}
