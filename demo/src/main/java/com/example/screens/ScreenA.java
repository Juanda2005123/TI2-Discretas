package com.example.screens;

import com.example.model.Horse;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class ScreenA {
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private List<Horse> horseList;

    public ScreenA(Canvas canvas, List<Horse> horseList) {
        this.canvas = canvas;
        graphicsContext = this.canvas.getGraphicsContext2D();
        this.horseList = horseList;
    }
    public void paintBlack(){
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

    }
}
