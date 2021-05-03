package ru.socialnetwork.services;

import ru.socialnetwork.persist.entities.Audio;
import ru.socialnetwork.repositories.AudioRepositoryImpl;

import java.util.List;

public class AudioService{

    private final AudioRepositoryImpl audioRepository;

    public AudioService() {
        this.audioRepository =  new AudioRepositoryImpl();
    }

    public Audio getOneById(Long id) {
        return audioRepository.getOneById(id);
    }

    public Audio getOneByName(String name) {
        return audioRepository.getOneByName(name);
    }

    public List<Audio> getListAudioBySinger(String singer) {
        return audioRepository.getListAudioBySinger(singer);
    }
}
