package com.example.model;

import java.text.DecimalFormat;

public class Player {
    private int money;
    private String name;
    private int racesWins;
    private double earnings;
    private Bet bet;

    public int getMoney() {
        return money;
    }
    public String getMoneySeparated(){
        DecimalFormat format = new DecimalFormat("#,###");

        return "$"+format.format(money);
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name){
        this.name = name;
        money = 100;
        racesWins = 0;
        earnings = 0;
    }
}
