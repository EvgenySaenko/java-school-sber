package ru.sber.javaschool.homework2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class ScalableThreadPool implements ThreadPool {
    private final int MIN_COUNT_THREADS;
    private final int MAX_COUNT_THREADS;
    private final LinkedBlockingQueue<Runnable> queueTasks;
    private final List<Thread> threads;
    private final int currentNumberOfRunningThreads;

    public ScalableThreadPool(int minCountThreads, int maxCountThreads) {
        this.MIN_COUNT_THREADS = minCountThreads;
        this.MAX_COUNT_THREADS = maxCountThreads;
        this.queueTasks = new LinkedBlockingQueue<>();
        this.threads = new ArrayList<>();
        this.currentNumberOfRunningThreads = 0;
    }

    @Override
    public void start() {
        int currentNumberOfRunningThreads = queueTasks.size() < MIN_COUNT_THREADS ? MIN_COUNT_THREADS : MAX_COUNT_THREADS;
        for (int i = 0; i < currentNumberOfRunningThreads; i++) {
            Thread t = new Thread(() -> {
                Runnable task = null;
                while (!Thread.interrupted()) {
                    try {
                        task = queueTasks.take();//достает задачу(внутри работает Рентрантлок,ставит замок => действие => снимает замок
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    task.run();
                }
            });
            threads.add(t);
            t.start();
        }
    }

    @Override
    public void execute(Runnable task) {
        try {
            queueTasks.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdownGivenAmountThreads(int amountThreads){
        if (threads.size() > queueTasks.size()){
        }
    }




    public void increasePower(int amountThreads){
        for (int i = 0; i < amountThreads; i++) {
            threads.get(i).interrupt();
            threads.remove(i);
        }
    }

}
