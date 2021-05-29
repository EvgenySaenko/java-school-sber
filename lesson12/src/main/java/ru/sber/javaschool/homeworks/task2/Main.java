package ru.sber.javaschool.homeworks.task2;


public class Main {//todo не решено!
    public static void main(String[] args) {
        Callback callback =  new Callback();

        Task task1 = new Task(1);
        Task task2 = new Task(2);
        Task task3 = new Task(3);
        Task task4 = new Task(4);
        Task task5 = new Task(5);

        ExecutionManager manager =  new Executor(4);
        Context context = manager.execute(callback,task1,task2,task3,task4,task5);
        context.getCompletedTaskCount();
    }
}
