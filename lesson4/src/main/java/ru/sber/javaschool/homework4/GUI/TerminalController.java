package ru.sber.javaschool.homework4.GUI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import ru.sber.javaschool.homework4.TerminalImpl;
import ru.sber.javaschool.homework4.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

//TODO - не обработана ошибка NumberFormatException при распарсивании "" пустого места
public class TerminalController implements Callback {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button showCash;

    @FXML
    private Button putCash;

    @FXML
    private Button getCash;

    @FXML
    private Button exit;

    @FXML
    private TextField tfPut;

    @FXML
    private TextField tfGet;

    @FXML
    private TextArea textArea;

    @FXML
    private Label labelTerminal;

    private TerminalImpl terminal;

    private final double defaultFontSize = 38;
    private final Font defaultFont = Font.font(defaultFontSize);

    private static boolean successfully = false;

    @Override
    public boolean callingBack(boolean b) {
        System.out.println(successfully = b);
        return successfully = b;
    }


    @FXML
    void initialize() {
        textArea.setEditable(false);
        this.terminal = new TerminalImpl(this);

    }

    public void showNoCorrectEnterGetCash() {//показываем сколько осталось попыток
        labelTerminal.setText("Введите сумму кратную 100");
        labelTerminal.setVisible(true);
    }

    public void showInsufficientFunds(){
        labelTerminal.setText("Недостаточно средств для снятия такой суммы: " + tfGet.getText() + "\n" + "Проверьте баланс средств!");
        labelTerminal.setVisible(true);
        tfGet.clear();
    }


    //при нажатии exit
    public void btnExit(ActionEvent actionEvent) {
        terminal.resetOnlineClient();//сброс текущего клиента
        Platform.exit();
        System.out.println("Клиент отключился");
    }

    //посмотреть баланс на счете
    public void showCash(ActionEvent actionEvent) {
        System.out.println(terminal.showCash());
        textArea.setFont(defaultFont);
        textArea.setText(String.valueOf(terminal.showCash()));
    }

    //положить деньги
    public void putCash(ActionEvent actionEvent) {
        tfPutCash(actionEvent);//когда нажмем положить => вызовим
    }

    //снять деньги
    public void getCash(ActionEvent actionEvent) {
        tfGetCash(actionEvent);//когда нажмем положить => вызовим
    }

    public void tfGetCash(ActionEvent actionEvent) {
        System.out.println("successfully до => " + successfully);
        try {
            if (Integer.parseInt(tfGet.getText()) % 100 == 0) {
                terminal.getCash(Integer.parseInt(tfGet.getText()));
                labelTerminal.setVisible(false);
                tfGet.clear();
            }
            if (Integer.parseInt(tfGet.getText()) % 100 != 0) {
                showNoCorrectEnterGetCash();
                tfGet.clear();
            }
        } catch (NumberFormatException e){
            throw new RuntimeException("Не удалось преобразование типов",e);
        }catch (IllegalArgumentException ex){
            throw new IllegalArgumentException("Введене превышающее значение средст на счете",ex);
        }finally{
            System.out.println("successfully после " + successfully);
            if (successfully) {
                successfully = false;
                showInsufficientFunds();
            } else {
                tfGet.clear();
            }
        }
    }

    public void tfPutCash(ActionEvent actionEvent) {
        if (Integer.parseInt(tfPut.getText()) % 100 == 0) {
            System.out.println("OKEY");
            terminal.putCash(Integer.parseInt(tfPut.getText()));
            labelTerminal.setVisible(false);
            tfPut.clear();
        } else if (Integer.parseInt(tfPut.getText()) % 100 != 0) {
            System.out.println("NOO  OKEY");
            showNoCorrectEnterGetCash();
            tfPut.clear();
        }
    }

}
