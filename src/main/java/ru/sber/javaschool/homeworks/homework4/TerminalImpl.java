package ru.sber.javaschool.homeworks.homework4;

import ru.sber.javaschool.homeworks.homework4.GUI.TerminalController;
import ru.sber.javaschool.homeworks.homework4.util.PinValidator;

public class TerminalImpl implements Terminal{

    private TerminalServer terminalServer;
    private TerminalController terminalController;
    private PinValidator pinValidator;

    public  TerminalImpl(){
        this.terminalServer =  new TerminalServer();
        this.terminalController = terminalController;
        this.pinValidator = new PinValidator();
    }

    public PinValidator getPinValidator() {
        return pinValidator;
    }

    public TerminalImpl(TerminalController terminalController){
        this.terminalServer =  new TerminalServer();
        this.terminalController = terminalController;
        this.pinValidator = new PinValidator();
    }





    @Override
    public int showCash() {
        return terminalServer.showCash();
    }

    @Override
    public boolean putCash(int amount) {
        if (pinValidator.isCorrect(amount)){
            return terminalServer.putCash(amount);
        }
        return false;
    }

    @Override
    public boolean getCash(int amount) throws IllegalArgumentException{
        if (pinValidator.isCorrect(amount)){
            this.terminalServer.registerCallBack(terminalController);
            return terminalServer.getCash(amount);
        }
        return false;
    }

    public void resetOnlineClient(){
        terminalServer.resetOnlineClient();
    }
}
