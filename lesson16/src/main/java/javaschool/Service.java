package javaschool;

import java.util.Date;
import java.util.List;

@Deprecated
public interface Service {
   // @Cache(cacheType = FILE, fileNamePrefix = "data", zip = true, identityBy = {String.class, double.class})
    List<String> run(String item, double value, Date date);

    //@Cache(cacheType = IN_MEMORY, listList = 100_000)
    List<String> work(String item);

}