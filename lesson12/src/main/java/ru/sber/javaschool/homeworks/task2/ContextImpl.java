package ru.sber.javaschool.homeworks.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContextImpl implements Context{
    private int completedTaskCount;
    private int failedTaskCount;
    private int interruptedTaskCount;
    private int interrupt;
    private int isFinished;


    public ContextImpl() {
        completedTaskCount = 0;
        failedTaskCount = 0;
        interruptedTaskCount = 0;
        interrupt = 0;
        isFinished = 0;
    }

    public void incrementCompletedTaskCount() {
        this.completedTaskCount++;
    }

    public void incrementFailedTaskCount() {
        this.failedTaskCount++;
    }

    public void incrementInterruptedTaskCount() {
        this.interruptedTaskCount++;
    }


    public void setInterrupt(int interrupt) {
        this.interrupt = interrupt;
    }

    public void setIsFinished(int isFinished) {
        this.isFinished = isFinished;
    }

    @Override//возвращает количество тасков, которые на текущий момент успешно выполнились.
    public int getCompletedTaskCount() {
        return completedTaskCount;
    }

    @Override//возвращает количество тасков, при выполнении которых произошел Exception.
    public int getFailedTaskCount() {
        return failedTaskCount;
    }

    //отменяет выполнения тасков, которые еще не начали выполняться.
    @Override//я так понял должен вернуть количество отмененных/неначатых задач
    public int getInterruptedTaskCount() {
        return interruptedTaskCount;
    }

    //todo непонятно
    @Override//возвращает количество тасков, которые не были выполены из-за отмены (вызовом предыдущего метода).
    public void interrupt() {

    }

    //todo непонятно
    @Override//вернет true, если все таски были выполнены или отменены, false в противном случае.
    public boolean isFinished() {
        return false;
    }
}
