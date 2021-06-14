package javaschool;


import java.nio.file.Path;
import java.nio.file.Paths;


public class MainProxy {
    public static void main(String[] args) {
        Path cacheDirectory = Paths.get("F:\\JavaSchoolSber\\java-school-sber\\lesson8\\cache");

        CacheProxy cacheProxy = new CacheProxy(cacheDirectory,5);

        HardService proxyHardService = (HardService) cacheProxy.cache(new HardServiceImpl());

        //run(proxyHardService);

        proxyHardService.doHardWorkForFile("copyPast8", "HappyNewYear");

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
        System.out.println(service.doHardWork("work1",11.5));
        System.out.println(service.doHardWork("work1",12.5));
        System.out.println(service.doHardWork("work1",22.5));

        System.out.println(service.doHardWork("work1",0.7));
        System.out.println(service.doHardWork("work1",1.7));
        System.out.println(service.doHardWork("work1",2.7));
        System.out.println(service.doHardWork("work1",2.7));

    }
}
