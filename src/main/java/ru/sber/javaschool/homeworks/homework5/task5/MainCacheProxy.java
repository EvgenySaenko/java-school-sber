package ru.sber.javaschool.homeworks.homework5.task5;

import java.lang.reflect.Proxy;


public class MainCacheProxy {
    public static void main(String[] args) {

        LibraryVK realObj =  new LibraryVKImpl();
        LibraryVK libraryProxy = (LibraryVK) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                     realObj.getClass().getInterfaces(),new CachedInvocationHandlerImpl(realObj));



        System.out.println(libraryProxy.getPhoto("3"));
        System.out.println(libraryProxy.getPhoto("4"));
        System.out.println(libraryProxy.getPhoto("5"));
        System.out.println(libraryProxy.getPhoto("5"));
        System.out.println(libraryProxy.getPhoto("5"));
        System.out.println(libraryProxy.getPhoto("5"));
        System.out.println(libraryProxy.getPhoto("11"));
        System.out.println(libraryProxy.getPhoto("10"));
        System.out.println(libraryProxy.getPhoto("9"));

    }
}
