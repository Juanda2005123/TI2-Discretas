package com.example.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Horse {
    private String name;
    private int wins;
    private double winningPercentage;
    private final DecimalFormat format;
    private final String PATH;

    //elementos graficos
    private List<Image> runs;
    private Canvas canvas;
    private GraphicsContext graphicsContext;

    //elementos espaciales
    private Position position;
    private State state;
    private int frameImg;



    public Horse(String name, String color){
        this.name = name;
        PATH = "/com/example/img/"+color+"/";
        runs = new ArrayList<>();
        wins = 0;

        frameImg = 0;
        state = State.IDLE;
        position = new Position(0,0);

        winningPercentage = 0;
        format = new DecimalFormat("0.0");

        for (int i = 0; i < 6 ; i++){
            Image image = new Image(getClass().getResourceAsStream(PATH+i+".png"));
            runs.add(image);
        }
    }

    public String getPercentage(){
        return format.format(winningPercentage)+"%";
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

    public Image getImage(int i){
        return runs.get(i);
    }
}