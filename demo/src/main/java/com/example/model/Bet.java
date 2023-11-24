package com.example.model;

public class Bet {
    private String horseName;
    private int money;

    public Bet(String horseName, int money) {
        this.horseName = horseName;
        this.money = money;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public int getMoney() {
        return money;
    }

    public void winMoney() {
        double moneyD = money*4.7;
        this.money = organize(moneyD);
    }
    public void secondMoney(){
        double moneyD = money*4.7;
        moneyD -= money;
        moneyD /= 3;
        this.money = organize(moneyD)+money;
    }
    public void loseMoney(){
        money = 0;
    }
    private int organize(double moneyD){
        int money = (int) Math.round(moneyD);
        int remainder = money % 10;
        return money + (remainder < 5 ? -remainder : 10-remainder);
    }
}
