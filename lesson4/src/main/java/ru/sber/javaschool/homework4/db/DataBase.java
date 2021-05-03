package ru.sber.javaschool.homework4.db;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataBase{
    private static DataBase dataBase;
    private static  Set<Integer> listPassword = null;
    private static  Map<Integer,Integer> mapPersonalAccounts = null;
    private static int ONLINE_CLIENT = 0;


    public static synchronized DataBase getDataBase(){
        if (dataBase == null){
            dataBase = new DataBase();
            listPassword = new HashSet<>();//проинициировали пароли
            initListPassword();
            mapPersonalAccounts =  new HashMap<>();
            initMapPersonalAccounts();//проинициировали счета
        }
        return dataBase;
    }

    public DataBase(){

    }

    public static void initListPassword(){
        listPassword.add(1234);
        listPassword.add(5555);
        listPassword.add(7171);
    }

    public static void initMapPersonalAccounts(){
        mapPersonalAccounts.put(1234,23_500);
        mapPersonalAccounts.put(5555,12_300);
        mapPersonalAccounts.put(7171,1_513_800);
    }

    public boolean isExist(Integer password){
        if (listPassword.contains(password)){
            ONLINE_CLIENT = password;
            System.out.println(ONLINE_CLIENT + " это онлайн клиент");
            return true;
        }
        return false;
    }

    public void resetOnlineClient(){
        ONLINE_CLIENT = 0;
    }

    public int showAmountOfMoney() {
        return mapPersonalAccounts.get(ONLINE_CLIENT);
    }

    public void putCashDataBase(int amount) {
        int tmp = mapPersonalAccounts.get(ONLINE_CLIENT);
        int balance =  tmp + amount;
        System.out.println("баланс -" + balance);
        mapPersonalAccounts.put(ONLINE_CLIENT, balance);
    }

    public void getCashDataBase(int amount) {
        int tmp = mapPersonalAccounts.get(ONLINE_CLIENT);
        int balance =  tmp - amount;
        System.out.println("баланс -" + balance);
        mapPersonalAccounts.put(ONLINE_CLIENT, balance);
    }
}
