package ru.sber.javaschool.homeworks.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executor implements ExecutionManager{
    private final ExecutorService service;
    private final List<Future<Integer>> listFuture;
    private List<Integer> result;
    private Context context;

    public Executor(int countThread) {
        this.service = Executors.newFixedThreadPool(countThread);
        this.listFuture = new ArrayList<>();
        this.result =  new ArrayList<>();
        this.context =  new ContextImpl();
    }

    @Override
    public Context execute(Runnable callback, Runnable...tasks) {
        for (Runnable task : tasks) {
            listFuture.add((Future<Integer>) service.submit(task));
        }
        service.shutdown();

        for (Future<Integer> integerFuture : listFuture) {
            try {
                result.add(integerFuture.get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
