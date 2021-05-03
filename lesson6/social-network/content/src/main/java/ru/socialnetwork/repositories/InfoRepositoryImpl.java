package ru.socialnetwork.repositories;

import ru.socialnetwork.persist.entities.Info;

import java.util.*;

public class InfoRepositoryImpl implements InfoRepository{

    private  Map<Long,Info> mapInfo;

    public InfoRepositoryImpl(){
        initInfo();
    }

    public void initInfo(){
        this.mapInfo = new HashMap<>();
        mapInfo.put(1L,new Info(1L,new GregorianCalendar(1992, Calendar.APRIL,23),
                "Rostov - on - Don","Rostov - on - Don","Rostov - on - Don","manager"));

        mapInfo.put(2L,new Info(2L,new GregorianCalendar(1978, Calendar.FEBRUARY,17),
                "Krasnodar","Krasnodar","Krasnodar","IT"));

        mapInfo.put(3L,new Info(3L,new GregorianCalendar(1987, Calendar.AUGUST,12),
                "Moscow","Moscow","Moscow","manager"));

    }


    @Override
    public Info getInfoById(Long id) {
        return mapInfo.get(id);
    }
}
