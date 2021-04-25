package ru.sber.javaschool.lessons.lesson5.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParametrizedAnnotation {
    String[] value();

    int number() default 1;

    TimeUnit enumUnit() default TimeUnit.HOURS;
}

@ParametrizedAnnotation("foo")
class A {
}

@ParametrizedAnnotation(value = {"foo", "bar"}, number = 10, enumUnit = TimeUnit.DAYS)
class Y {
}
