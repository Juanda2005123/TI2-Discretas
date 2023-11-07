package com.example.model;

import java.text.DecimalFormat;

public class Horse {
    private String name;
    private int wins;
    private double winningPercentage;
    private final DecimalFormat format;
    public Horse(String name){
        this.name = name;
        wins = 0;
        winningPercentage = 0;
        format = new DecimalFormat("0.0");
    }

    public String getPercentage(){
        return format.format(winningPercentage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public double getWinningPercentage() {
        return winningPercentage;
    }

    public void setWinningPercentage(int totalRaces) {
        this.winningPercentage = (double) (wins/totalRaces)*100;
    }
}