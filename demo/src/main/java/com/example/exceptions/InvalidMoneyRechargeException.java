package com.example.exceptions;

public class InvalidMoneyRechargeException {
    private String msg;
    private boolean send;

    public String getMsg() {
        return msg;
    }

    public boolean isSend() {
        return send;
    }

    public InvalidMoneyRechargeException(int money){
        send = false;
        validRecharge(money);
    }
    private void validRecharge(int money){
        if((money%50)!=0){
            send = true;
            msg = "The amount must be a multiple of 50";
        } else if (money<250) {
            send = true;
            msg = "The amount must be greater than $250";
        } else if (money>100000) {
            send = true;
            msg = "The amount must be less than $100.000";
        }
    }
}
