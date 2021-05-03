package ru.socialnetwork.controllers;

import ru.socialnetwork.persist.entities.Audio;
import ru.socialnetwork.services.AudioService;

import java.util.List;

public class AudioController {

    private final AudioService audioService;

    public AudioController() {
        this.audioService = new AudioService();
    }

    public Audio getOneById(Long id) {
        return audioService.getOneById(id);
    }

    public Audio getOneByName(String name) {
        return audioService.getOneByName(name);
    }

    public List<Audio> getListAudioBySinger(String singer) {
        return audioService.getListAudioBySinger(singer);
    }
}
