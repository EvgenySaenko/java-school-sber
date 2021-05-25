package ru.sber.javaschool.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final int COUNT_THREADS;
    private final LinkedBlockingQueue<Runnable> queueTasks;
    private final List<Thread> threads;

    public FixedThreadPool(int countThreads) {
        this.COUNT_THREADS = countThreads;
        this.queueTasks = new LinkedBlockingQueue<>();
        this.threads = new ArrayList<>();
    }

    @Override
    public void start() {
        for (int i = 0; i < COUNT_THREADS; i++) {
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

    public void shutdownAll() {
        for (int i = 0; i < threads.size() - 1; i++) {
            int finalI = i;
            new Thread(() -> {
                threads.get(finalI).interrupt();
            }).start();
        }
    }
}
