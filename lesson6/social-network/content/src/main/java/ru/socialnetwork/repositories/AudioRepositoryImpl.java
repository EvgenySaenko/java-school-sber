package ru.socialnetwork.repositories;

import ru.socialnetwork.persist.entities.Audio;

import java.util.*;

public class AudioRepositoryImpl implements AudioRepository{

    private Map<Long,Audio> mapAudio;

    public AudioRepositoryImpl() {
        initAudio();
    }

    public void initAudio(){
        this.mapAudio =  new HashMap<>();
        mapAudio.put(1L,new Audio(1L,"Она не такая","Dabro"));
        mapAudio.put(2L,new Audio(2L,"На крыше","Dabro"));
        mapAudio.put(3L,new Audio(3L,"Комета","JONY"));
        mapAudio.put(4L,new Audio(4L,"Юность","Dabro"));
        mapAudio.put(5L,new Audio(5L,"Not Afraid","Eminem"));
        mapAudio.put(6L,new Audio(6L,"Перемен","Кино"));
        mapAudio.put(7L,new Audio(7L,"Город","Танцы Минус"));
    }


    @Override
    public Audio getOneById(Long id) {
        return mapAudio.get(id);
    }

    @Override
    public Audio getOneByName(String name) {
        Collection<Audio> values = mapAudio.values();
        for(Audio audio: values){
            if (audio.getName().equals(name)){
                return audio;
            }
        }
        throw new RuntimeException("Нет такой песни");
    }

    @Override
    public List<Audio> getListAudioBySinger(String singer) {
        Collection<Audio> values = mapAudio.values();
        List<Audio> musicListBySinger = new ArrayList<>();
        for(Audio audio: values){
            if (audio.getSinger().equals(singer)){
                musicListBySinger.add(audio);
            }
        }
        return musicListBySinger;
    }


}
