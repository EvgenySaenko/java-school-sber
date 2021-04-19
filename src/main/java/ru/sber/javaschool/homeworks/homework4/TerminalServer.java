package ru.sber.javaschool.homeworks.homework4;

import ru.sber.javaschool.homeworks.homework4.db.DataBase;
import ru.sber.javaschool.homeworks.homework4.util.Callback;

public class TerminalServer implements Terminal {
    private DataBase dataBase;

    Callback callback;

    public void registerCallBack(Callback callback){
        this.callback = callback;
    }

    public TerminalServer(){
        this.dataBase =  DataBase.getDataBase();
    }

    @Override
    public int showCash() {
        return dataBase.showAmountOfMoney();
    }

    @Override
    public boolean putCash(int amount) {
       dataBase.putCashDataBase(amount);
       return true;
    }

    @Override
    public boolean getCash(int amount) throws IllegalArgumentException{
        if (amount > dataBase.showAmountOfMoney()){
            callback.callingBack(amount > dataBase.showAmountOfMoney());
            System.out.println(callback.callingBack(amount > dataBase.showAmountOfMoney()) + " сервер отправил");
            throw new IllegalArgumentException("Введено превышающее значение средств на счете");
        }else {
            System.out.println("terminal server пробросил искл");
            dataBase.getCashDataBase(amount);
            return true;
        }
    }

    public void resetOnlineClient(){
        dataBase.resetOnlineClient();
    }


}
