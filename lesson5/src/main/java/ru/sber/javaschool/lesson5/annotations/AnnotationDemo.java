package ru.sber.javaschool.lesson5.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@TypeAnno
public class AnnotationDemo {
    @interface Anno {
    }

    @FieldAnno
    String str;

    public AnnotationDemo( String str) {
        int x = 5;
        this.str = str + x;
    }

    <T> T method() {
        return null;
    }

}

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
@interface TypeAnno {
}


@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
@interface FieldAnno {
}
