package ru.sber.javaschool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cache {

    enum Type{
        IN_MEMORY,FILE
    }

    Type cacheType() default Type.IN_MEMORY;

    String fileNamePrefix() default "data";

    boolean zip() default false;

    Class<?> [] identityBy() default {Object.class,Object.class};

    int size();



}
