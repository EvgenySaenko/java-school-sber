package ru.sber.javaschool;

import static ru.sber.javaschool.Cache.Type.FILE;
import static ru.sber.javaschool.Cache.Type.IN_MEMORY;

public interface HardService {
    @Cache(cacheType = FILE,size = 100_000)
    double doHardWork(String name, double item);
}
