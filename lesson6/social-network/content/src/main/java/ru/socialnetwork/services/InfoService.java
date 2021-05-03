package ru.socialnetwork.services;

import ru.socialnetwork.persist.entities.Info;
import ru.socialnetwork.repositories.InfoRepositoryImpl;

public class InfoService {
    private final InfoRepositoryImpl infoRepository;

    public InfoService(){
        this.infoRepository =  new InfoRepositoryImpl();
    }

    public Info getInfoById(Long id) {
        return infoRepository.getInfoById(id);
    }
}
