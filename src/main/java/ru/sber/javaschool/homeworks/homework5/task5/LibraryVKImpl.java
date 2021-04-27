package ru.sber.javaschool.homeworks.homework5.task5;


import java.util.HashMap;
import java.util.Map;

public class LibraryVKImpl implements LibraryVK{

    private final Map<String,Photo> photoBase =  new HashMap<>();

    public LibraryVKImpl() {
        initPhotoBase();
    }

    @Override
    public Photo getPhoto(String id) {
        System.out.println("вызван getPhoto");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (photoBase.containsKey(id)){
            return photoBase.get(id);
        }
        return null;
    }

    public void initPhotoBase(){
        photoBase.put("1",new Photo("1","photo#1"));
        photoBase.put("2",new Photo("2","photo#2"));
        photoBase.put("3",new Photo("3","photo#3"));
        photoBase.put("4",new Photo("4","photo#4"));
        photoBase.put("5",new Photo("5","photo#5"));
        photoBase.put("6",new Photo("6","photo#6"));
        photoBase.put("7",new Photo("7","photo#7"));
        photoBase.put("8",new Photo("8","photo#8"));
        photoBase.put("9",new Photo("9","photo#9"));
        photoBase.put("10",new Photo("10","photo#10"));
        photoBase.put("11",new Photo("11","photo#11"));
    }
}
