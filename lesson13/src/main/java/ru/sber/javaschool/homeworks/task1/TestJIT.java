package ru.sber.javaschool.homeworks.task1;


import java.util.HashMap;
import java.util.Map;

/**
 * По JIT:
 * Сделать цикл на 100000 итераций, в цикле в предварительно созданную Map<Integer, String>
 * сложить ключ - индекс, значение - "value" + индекс
 * Запустить с опцией -XX:+PrintCompilation, проанализировать информацию в консоли
 * Запустить с опцией -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining ,
 * проанализировать информацию в консоли
 * **/
public class TestJIT {
    private static Map<Integer,String> map = new HashMap<>();
    public static void main(String[] args) {

        for (int i = 0; i < 100_000; i++) {
            map.put(i,"Model" + i);
        }

    }
}
