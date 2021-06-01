package ru.sber.javaschool.homeworks.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executor implements ExecutionManager{
    private ExecutorService service;
    private final List<Future<?>> listFuture;
    private List<Integer> result;
    private ContextImpl context;

    public Executor(int countThread) {

        this.listFuture = new ArrayList<>();
        this.result =  new ArrayList<>();
        this.context =  new ContextImpl();
    }

    @Override
    public Context execute(Runnable callback, Runnable...tasks) {
        this.service = Executors.newFixedThreadPool(tasks.length);
        for (Runnable task : tasks) {
            Future<?> future = service.submit(task);
            listFuture.add(future);//добавили в лист

        }

        for (Future<?> future : listFuture) {//перебираем лист фьюч
            service.execute(()->{
                if(future.isDone()){//если выполнена
                    context.incrementCompletedTaskCount();
                }
                if (future.isCancelled()){
                    context.incrementFailedTaskCount();
                }
                //cancel()- отмена выполнения задачи; если задача уже стартована и параметр mayInterrupt равен true,
                // то она прерывается, в противном случае, если вычисления еще не начаты, то они и не начнутся.
                // При успешной отмене выполнения задачи метод возвращает значение true
                if (future.cancel(false)){//false - чтобы прервать неначатые задачи
                    context.incrementInterruptedTaskCount();
                }
            });
        }
        service.shutdown();
        return context;
    }
}
