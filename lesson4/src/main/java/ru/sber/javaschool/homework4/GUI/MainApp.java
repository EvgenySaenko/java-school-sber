package ru.sber.javaschool.homework4.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



//TODO:
// успел только накидать структуру очень много нюансов - 4 дня мало (
// подумать как убрать обработку ексепшен из интерфейса в TerminalImpl, есть вопросы как это все сделать правильно
// вообщем не успел причесать код и все поставить на нужные места ((

/**
 * Реализовано:
 *   - ограничение на ввод всего кроме цифр
 *   - ограничен ввод более 4 цифр
 *   - проверка валидности:
 *      - на пустую строку под вопросом(?)
 *      - проверка на длину в 4 символа
 *   - интерфейс из 2-х окон (MainCOntroller and TerminalCOntroller)
 *      - MainCOntroller окно авторизации - ввода ПИН-КОДА
 *      - TerminalCOntroller окно работы с терминалом с кнопками (баланс, снять, положить, выйти)
 *        - и окно отображения средств на счете
 *   - База Данных сделана паттерном singleton (примитивно список паролей и мапа<пароль, его деньги на счете>
 *   - Server and TerminalImpl - реализуют интерфейс Terminal каждый по своему
 *
 *   Интерфейс вызывает метод Терпинала(getCash) =>Terminal вызывает в своем методе getCash(метод сервера) =>
 *   сервер вызывает метод базы => база выполняет списание или пополнение средств
 *
 *    *   - если пароль введен не верно
 *              - выводится информация о количестве попыток
 *              - если попытки закончились сразу включается таймер и показывается что терминал заблокирован на 10с
 *              - если в это время попробовать ввести пароль - выводится инфа об оставшемся времени ожидании до разблокировки
 *              - после прошедшего времени попытки обновляются до 3;
 *
 *   *     - можно посмотреть баланс, положить деньги, снять деньги
 *   *     - если введенная сумма не кратна 100 операции не проходят
 *             - выводится объяснение пользователю и ексепшен в консоль
 *
 *   CallBack - реализован был чтобы была возможность узнать прошел платеж или нет
 *              так как если выскакивала ошибка то ретурна не было
 *
 * */
public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        primaryStage.setTitle("TERMINAL");
        Scene scene = new Scene(root,600,400);
        scene.getStylesheets().add("/main.css");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
