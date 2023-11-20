package com.example.exceptions;

public class InvalidMoneyBetException extends Exception{
    private String msg;
    private boolean send;

    public String getMsg() {
        return msg;
    }

    public boolean isSend() {
        return send;
    }
    public InvalidMoneyBetException(int money, int playerMoney){
        send = false;
        validBet(money);
        enoughMoney(money, playerMoney);
    }
    private void validBet(int money){

        if((money%50)!=0){
            send = true;
            msg = "The amount must be a multiple of 50";
        } else if (money<50) {
            send = true;
            msg = "The amount must be greater than or equal to $50";
        } else if (money>10000) {
            send = true;
            msg = "The amount must be less than or equals to $10.000";
        }
    }
    private void enoughMoney(int money, int playerMoney){
        if(playerMoney<money){
            send = true;
            msg = "The player does not have enough money";
        }
    }
}
