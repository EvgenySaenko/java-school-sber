package ru.sber.javaschool.homeworks.task2;

public interface Context {
    //возвращает количество тасков, которые на текущий момент успешно выполнились.
    int getCompletedTaskCount();

    //возвращает количество тасков, при выполнении которых произошел Exception.
    int getFailedTaskCount();

    //отменяет выполнения тасков, которые еще не начали выполняться.
    int getInterruptedTaskCount();

    //возвращает количество тасков, которые не были выполены из-за отмены (вызовом предыдущего метода).
    void interrupt();

    //вернет true, если все таски были выполнены или отменены, false в противном случае.
    boolean isFinished();
}

