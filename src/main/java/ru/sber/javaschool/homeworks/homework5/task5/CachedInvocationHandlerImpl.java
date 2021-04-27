package ru.sber.javaschool.homeworks.homework5.task5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class CachedInvocationHandlerImpl implements InvocationHandler {

    private final List<Map<Object,Object>> listMap =  new ArrayList<>();

    private final Map<Set<Object>,Map<Object,Object>> cacheMap = new HashMap<>();

    Map<Object,Map<Object,Object>> baseCache =  new HashMap<>();
    Map<Object,Object> argAndResult = new HashMap<>();

    private final Object real;

    //TODO не доделал не смог
    public CachedInvocationHandlerImpl(Object real) {
        this.real = real;
    }

//    Кеширующий прокси перехватывает вызовы интерфейса.
//    Если метод помечен аннотацией @Cache, то:
//    Проверяет есть ли в кеше результат, если есть, то возвращает его.
//            Иначе, вызывает реальный метод, кеширует результат и возвращает его.
//    Если метод не помечен аннотацией @Cache, просто делегирует метод реализации

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("arguments = " + args);
        baseCache.forEach((k, v) -> System.out.print(k + " : " + v + "\n"));

        if (!method.isAnnotationPresent(Cache.class)){//если аннотации кеша нет над методом, вызываем обычную реализацию метода
            return realMethodCall(method,args);
        }
        if (!baseCache.containsKey(method)){//если нет ключа с этим методом
            argAndResult.put(args, realMethodCall(method, args));//кладем в мапу такие аргументы и результат к ним
            baseCache.put(method, argAndResult);//кладем метод и мапу (аргумент - значение)
            System.out.println(baseCache.get(method).get(args));
            return baseCache.get(method).get(args);//вернем результат
        }

        if (!argAndResult.containsKey(args)){//если нет таких аргументов, положим аргументы и новый результат
            argAndResult.put(args, realMethodCall(method,args));
            baseCache.put(method, argAndResult);
        }
        return baseCache.get(method).get(args);

    }

    private Object realMethodCall(Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(real, args);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Ошибка вызова реального метода",e);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

}
