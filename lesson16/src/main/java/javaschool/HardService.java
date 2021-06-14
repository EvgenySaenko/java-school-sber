package javaschool;


import static javaschool.Cache.Type.FILE;
import static javaschool.Cache.Type.IN_MEMORY;

public interface HardService {
    @Cache(cacheType = IN_MEMORY,size = 5)
    double doHardWork(String name, double item);

    @Cache(cacheType = FILE,fileNamePrefix = "file",zip = true,identityBy = {String.class,String.class},size = 5)
    String doHardWorkForFile(String name, String item);
}
