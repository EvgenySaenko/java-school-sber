package ru.socialnetwork.repositories;

import ru.socialnetwork.persist.entities.Audio;

import java.util.List;


public interface AudioRepository {
    Audio getOneById(Long id);
    Audio getOneByName(String name);
    List<Audio>getListAudioBySinger(String singer);

}
