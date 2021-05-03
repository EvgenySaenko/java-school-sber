package ru.sber.javaschool.homework4.util;

import ru.sber.javaschool.homeworks.homework4.db.DataBase;

import javax.xml.bind.ValidationException;

//проверка валидности данных
//TODO - проверка если ничего не ввели
public class PinValidator {
    private static final int CORRECT_LENGTH_PASSWORD = 4;
    private static final int INCORRECT_LENGTH_PASSWORD = 0;
    private static final int HUNDRED = 100;

    private DataBase dataBase;

    public PinValidator(){
        dataBase = DataBase.getDataBase();//инициализировалли данные
    }

    public boolean isCorrectPassword(int password){//корректность ввода
       if (String.valueOf(password).length() != CORRECT_LENGTH_PASSWORD || password == INCORRECT_LENGTH_PASSWORD ||
               String.valueOf(password).equals("")){
           try {
               throw new ValidationException("Введен не корректный ПИН-КОД => " + password);
           } catch (ValidationException e) {
               e.printStackTrace();
           }
       }
       return checkPassword(password);//если корректно ввели проверяем в базе
    }

    public boolean isCorrect(int amount){
        return amount % HUNDRED == 0;
    }


    public boolean checkPassword(int password){//проверка в базе
      return dataBase.isExist(password);
    }
    
}
