package ru.sber.javaschool.homework4.GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.sber.javaschool.homeworks.homework4.TerminalImpl;

import javax.security.auth.login.AccountLockedException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.UnaryOperator;

public class MainController {

    private TerminalImpl terminal;
    private static int attempts = 3;
    private static int amountSec = 10;
    private static boolean timerActive = false;


    public MainController() {
        this.terminal = new TerminalImpl();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField pinCode;

    @FXML
    private Button enterButton;

    @FXML
    private Label errorLabel;


    //ограничиваем количество символов ПИН КОДА
    public static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }

    //ввести можно только цифры
    public void integerFilter() {
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String input = change.getText();
            if (input.matches("[0-9]*")) {
                return change;
            }
            return null;
        };
        pinCode.setTextFormatter(new TextFormatter<String>(integerFilter));
    }

    public static int getSecond(int second) {
        return amountSec = second;
    }

    public void timerTenSeconds() {
        Timer timer = new Timer();
        int begin = 0;
        int timeInterval = 1000;
        timer.schedule(new TimerTask() {
            int counter = 0;

            @Override
            public void run() {
                timerActive = true;
                counter++;
                if (counter >= 10) {
                    timerActive = false;
                    attempts = 3;
                    amountSec = 0;
                    timer.cancel();
                } else {
                    System.out.println(counter);
                    getSecond(10 - counter);
                }
            }
        }, begin, timeInterval);
    }

    public void showCountAttempts(){//показываем сколько осталось попыток
        errorLabel.setText("*Не корректный ПИН-КОД (введите 4-x значное число от 0 до 9)(осталось " + attempts + " попытки)");
        errorLabel.setVisible(true);
        pinCode.clear();
    }

    public void showWhatTimeIsIt(){//через сколько разблокируют
        errorLabel.setText("Вы исчерпали количество попыток. Вход разблокируется через " + amountSec + " секунд");
        errorLabel.setVisible(true);
        pinCode.clear();
    }

    public void showDidNotEnterAnything(){//если ничео не введено
        errorLabel.setText("Вы ничего не ввели!");
        errorLabel.setVisible(true);
        pinCode.clear();
    }


    public void enterButton(ActionEvent actionEvent) {
        if (pinCode.getText().length() == 0){
            showDidNotEnterAnything();
        }
        System.out.println("Вы ввели: " + pinCode.getText());
        int password = Integer.parseInt(pinCode.getText());
        if (terminal.getPinValidator().isCorrectPassword(password) && attempts > 0) {//если пин код валидный и проверится в базе
            enterButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/terminal.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } else {
            if (attempts == 1){//если ввели не верно а попытка одна, уменьшаем ее в 0 и запуск таймер
                attempts -= 1;
                timerTenSeconds();//запускаем таймер на 10 секунд
                showWhatTimeIsIt();//показываем время
            }else if (attempts > 0) {
                attempts -= 1;
                showCountAttempts();
            }else if (attempts == 0){
                try {
                    throw new AccountLockedException("Аккаунт заблокирован на " + amountSec + " секунд");
                } catch (AccountLockedException e) {
                    throw new RuntimeException(e);
                }finally {
                    showWhatTimeIsIt();
                }
            }
        }
    }


    @FXML
    void initialize() {
        addTextLimiter(pinCode, 4);//ограничили ввод количества символов
        integerFilter();//установили фильтр только цифры
        //errorLabel.setVisible(false);

    }


}