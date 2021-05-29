package ru.sber.javaschool.homeworks.task2;

public class ContextImpl implements Context{
    private int completedTaskCount;
    private int failedTaskCount;
    private int interruptedTaskCount;
    private int interrupt;
    private int isFinished;





    @Override
    public int getCompletedTaskCount() {
        return 0;
    }

    @Override
    public int getFailedTaskCount() {
        return 0;
    }

    @Override//отменяет выполнения тасков, которые еще не начали выполняться.
    public int getInterruptedTaskCount() {
        return 0;
    }

    @Override
    public void interrupt() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
