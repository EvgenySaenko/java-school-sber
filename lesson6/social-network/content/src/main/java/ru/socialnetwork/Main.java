package ru.socialnetwork;

import ru.socialnetwork.controllers.AudioController;
import ru.socialnetwork.controllers.InfoController;

public class Main {
    public static void main(String[] args) {
        InfoController infoController = new InfoController();
        System.out.println(infoController.getInfoById(2L));

        AudioController audioController = new AudioController();
//        System.out.println(audioController.getOneById(1L));
//        System.out.println(audioController.getOneByName("Юность"));
        System.out.println(audioController.getListAudioBySinger("Dabro"));
    }
}
