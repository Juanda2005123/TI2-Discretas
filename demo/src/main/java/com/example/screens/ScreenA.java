package com.example.screens;

import com.example.model.Horse;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.List;

public class ScreenA {
    private final String PATH = "/com/example/img/stage/fondo.jpg";
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private List<Horse> horseList;

    public ScreenA(Canvas canvas, List<Horse> horseList) {
        this.canvas = canvas;
        graphicsContext = this.canvas.getGraphicsContext2D();
        this.horseList = horseList;

        for (int i = 0; i < horseList.size(); i++){
            horseList.get(i).setPosition(160, 110+85*i);
        }
    }
    public void paint(){
        Image image = new Image(getClass().getResourceAsStream(PATH));
        graphicsContext.drawImage(image,0,0,1328,672);
        for (var horse:
             horseList) {
            horse.paint();
        }
    }
}
