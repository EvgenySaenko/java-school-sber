package ru.sber.javaschool.homework;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

//1) FixedThreadPool - Количество потоков задается в конструкторе и не меняется.
public class FixedThreadPool implements ThreadPool {
    private final Queue<Runnable> queueTasks;
    private final int COUNT_THREAD;


    public FixedThreadPool(int countThread) {
        this.COUNT_THREAD = countThread;
        this.queueTasks = new LinkedList<>();
    }


    @Override
    public void start() {
        for (int i = 0; i < COUNT_THREAD; i++) {
            new Thread(() -> {
                Runnable task;
                while (true) {
                    synchronized (queueTasks) {
                        while (this.queueTasks.peek() == null) {//если нет задачи в очереди => спит
                            try {
                                queueTasks.wait();
                                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                            } catch (InterruptedException e) {
                                System.out.println("Ошибка во время ожидания очереди: " + e.getMessage());
                            }
                        }
                        task = queueTasks.poll();
                    }
                    task.run();
                }
            }).start();
        }


    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (queueTasks) {
            this.queueTasks.add(runnable);
            queueTasks.notify();
        }
    }

}
