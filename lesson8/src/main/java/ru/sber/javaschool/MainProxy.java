package ru.sber.javaschool;


import java.nio.file.Path;
import java.nio.file.Paths;



public class MainProxy {
    public static void main(String[] args) {
        Path cacheDirectory = Paths.get("F:\\JavaSchoolSber\\java-school-sber\\lesson8\\cache");

        CacheProxy cacheProxy = new CacheProxy(cacheDirectory,100_000);

        HardService proxyHardService = (HardService) cacheProxy.cache(new HardServiceImpl());

        run(proxyHardService);
    }

    public static void run(HardService service){
        System.out.println(service.doHardWork("work1",3.5));
        System.out.println(service.doHardWork("work1",4.5));
        System.out.println(service.doHardWork("work1",2.5));
        System.out.println(service.doHardWork("work1",2.5));
        System.out.println(service.doHardWork("work1",2.5));
        System.out.println(service.doHardWork("work1",5.5));
        System.out.println(service.doHardWork("work1",7.5));
        System.out.println(service.doHardWork("work1",7.5));
        System.out.println(service.doHardWork("work1",7.5));

    }
}
