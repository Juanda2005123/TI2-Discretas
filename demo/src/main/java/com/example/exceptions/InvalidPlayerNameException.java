package com.example.exceptions;

import javafx.scene.control.Alert;

public class InvalidPlayerNameException extends Exception{
    private boolean send;
    private String msg;
    public InvalidPlayerNameException(String playerName) {
        send = false;
        validName(playerName);
    }
    private void validName(String playerName){

        if(playerName.length()>20){
            send = true;
            msg = "The name is too long";
        } else if(playerName.equals("")){
            send = true;
            msg = "The player must have a name";
        } else if (playerName.length()<2){
            send = true;
            msg = "The name is too short";
        }
    }


    public boolean isSend() {
        return send;
    }

    public String getMsg() {
        return msg;
    }


}
