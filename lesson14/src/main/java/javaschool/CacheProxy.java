package javaschool;


import java.lang.reflect.Proxy;
import java.nio.file.Path;

public class CacheProxy{

    private final Path cacheDirectory;
    private final int maxCapacity;

    public CacheProxy(Path cacheDirectory, int maxCapacity) {
        this.cacheDirectory = cacheDirectory;
        this.maxCapacity = maxCapacity;
    }

    public Object cache(Object proxyCandidate){
        ClassLoader currentClassLoader =  proxyCandidate.getClass().getClassLoader();
        Class<?> [] interfaces = proxyCandidate.getClass().getInterfaces();
        return Proxy.newProxyInstance(currentClassLoader,interfaces,new CacheProxyHandler(proxyCandidate,maxCapacity,cacheDirectory));
    }
}
