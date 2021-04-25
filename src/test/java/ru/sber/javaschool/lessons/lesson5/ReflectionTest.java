package ru.sber.javaschool.lessons.lesson5;

import org.junit.Test;
import ru.sber.javaschool.lessons.lesson5.reflection.HelloWorld;
import ru.sber.javaschool.lessons.lesson5.reflection.ManyField;
import ru.sber.javaschool.lessons.lesson5.reflection.ReflectionHelper;


import java.lang.reflect.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ReflectionTest {



    @Test
    public void exampleGetClass(){

    }

    @Test
    public void instanceClassAndInvokeMethod() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<HelloWorld> constructor = HelloWorld.class.getConstructor(String.class);
        HelloWorld hello = constructor.newInstance("World");
        Method sayHello = HelloWorld.class.getDeclaredMethod("sayHello");
        System.out.println(Modifier.toString(sayHello.getModifiers()));
        sayHello.setAccessible(true);
        sayHello.invoke(hello);
    }


    @Test
    public void printSuperclass() {
        System.out.println(String.class.getSuperclass());
        System.out.println(Object.class.getSuperclass());
    }

    @Test
    public void changePrivateField() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        HelloWorld helloWorld = new HelloWorld("World");
        Method sayHello = HelloWorld.class.getDeclaredMethod("sayHello");
        sayHello.setAccessible(true);
        sayHello.invoke(helloWorld);

        Field name = HelloWorld.class.getDeclaredField("name");
        name.setAccessible(true);
        name.set(helloWorld, "Хуцкер!!");
        sayHello.invoke(helloWorld);

    }

    @Test
    public void checkFieldNotNullValue() throws IllegalAccessException {
        ManyField manyField1 = new ManyField("field1", "field2", 4, true);
        ManyField manyField2 = new ManyField("field2", null, 10, true);

        if (ReflectionHelper.checkValueNotNull(manyField1)) {
            System.out.println("В manyField1 все поля != Null");
        }
        if (ReflectionHelper.checkValueNotNull(manyField2)) {
            System.out.println("В manyField2 все поля != Null");
        } else {
            System.out.println("В manyField2 есть поле = null");
        }

    }

    @Test
    public void reflectionCopy() throws IllegalAccessException {
        ManyField manyField1 = new ManyField("field1", "field2", 4, true);
        ManyField manyField2 = new ManyField("field2", null, 10, true);
        System.out.println(manyField2);
        ReflectionHelper.copyObject(manyField1, manyField2);
        System.out.println(manyField2);

        assertEquals(manyField1,manyField2);
    }

    @Test
    public void checkValidLength() throws IllegalAccessException {
       // ManyField manyField1 = new ManyField("field1", "field2", 4, true);
        ManyField manyField1 = new ManyField("Sadsadasdasdasdasd", "fdsadasdasdield2", 4, true);
        assertDoesNotThrow(() -> {
            ReflectionHelper.validateStringLength(manyField1);
        });
    }

    @Test
    public void checkValidLengthError() throws IllegalAccessException {
        ManyField manyField1 = new ManyField("field1asdasdasdasd", "field2", 4, true);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            ReflectionHelper.validateStringLength(manyField1);
        });
        System.out.println(exception.toString());
    }
}
