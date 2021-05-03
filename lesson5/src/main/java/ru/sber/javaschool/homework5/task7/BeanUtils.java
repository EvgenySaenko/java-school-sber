package ru.sber.javaschool.homework5.task7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class BeanUtils {
    /**
     * Scans object "from" for all getters.
     * If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        if (to == null) throw new RuntimeException("Объект to не проинициализирован");
        if (from == null) throw new RuntimeException("Объект from не проинициализирован");

        Class<?> clazzFrom = from.getClass();
        Method[] methodsFrom =  clazzFrom.getMethods();//получили все public methods Object from

        Class<?> clazzTo = from.getClass();
        Method[] methodsTo =  clazzTo.getMethods();//получили все public methods Object to

        Set<String> geterNamesFrom = new HashSet<>();//получим названия гетеров from
        Set<String> seterNamesTo = new HashSet<>();//названия сетеров to

    //TODO вообще не понял как это надо было сделать


    }

}
