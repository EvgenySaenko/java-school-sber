package ru.socialnetwork.controllers;

import ru.socialnetwork.persist.entities.Info;
import ru.socialnetwork.services.InfoService;

public class InfoController {

    public InfoService infoService;

    public InfoController() {
        this.infoService = new InfoService();
    }

    public Info getInfoById(Long id) {
        return infoService.getInfoById(id);
    }

}
