package ru.sber.javaschool.homeworks.task1;

public class ExceptionsResult extends RuntimeException{

    public ExceptionsResult(String message, Exception e){
        super(message);
    }
}
