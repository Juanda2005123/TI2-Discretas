package com.example.model;

public class Player {
    private int money;
    private String name;
    private int racesWins;
    private double earnings;

    public int getMoney() {
        return money;
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
