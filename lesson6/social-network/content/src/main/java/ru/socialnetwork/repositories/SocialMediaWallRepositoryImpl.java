package ru.socialnetwork.repositories;

import ru.socialnetwork.persist.entities.SocialMediaWall;

import java.util.HashMap;
import java.util.Map;

public class SocialMediaWallRepositoryImpl implements SocialMediaWallRepository{

    private Map<Long,SocialMediaWall> listSocialMediaWalls;

    public SocialMediaWallRepositoryImpl() {
        initListSocialMediaWalls();
    }

    public void initListSocialMediaWalls(){
        this.listSocialMediaWalls = new HashMap<>();
    }



    @Override
    public SocialMediaWall getWallById(Long id) {
        return listSocialMediaWalls.get(id);
    }
}
