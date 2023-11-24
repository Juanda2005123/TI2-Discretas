package com.example.model;

import com.example.control.Controller;
import com.example.util.GraphList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private int horseWidth;
    private int horseHeight;
    private GraphList graph;
    private int minimunPath;
    private ArrayList<Double> animationSpeed;
    private ArrayList<Integer> countSpeed;
    private int runAnimation;
    private int countAnimation;
    private Controller controller;
    private Random ran = new Random();
    private long raceTime;
    private com.example.model.Timer timer;


    public Horse(String name, String color){
        timer = new Timer();
        this.name = name;
        PATH = "/com/example/img/"+color+"/";
        runs = new ArrayList<>();
        wins = 0;

        frameImg = 0;
        state = State.IDLE;
        position = new Position(0,0);
        horseWidth = 163;
        horseHeight = 92;

        winningPercentage = 0;
        format = new DecimalFormat("0.0");

        for (int i = 0; i < 6 ; i++){
            Image image = new Image(getClass().getResourceAsStream(PATH+i+".png"));
            runs.add(image);
        }
    }
    public void newGraphDirected(){
        graph = new GraphList(51);
        graph.startNewRandomWeightGraphDirected();
    }
    public int getMinimunPath(){
        return minimunPath;
    }
    public void newGraphUndirected(){
        graph = new GraphList(51);
        graph.startNewRandomWeightGraphUndirected();
    }
    public void graphDijkstra(){
        minimunPath = graph.dijkstra(1,50);
    }
    public void graphfloydWarshall(){
        graph.fillMatrix();
        graph.floydWarshall();
        minimunPath = graph.getMatrix()[0][49];
    }
    public void startHorse(Canvas canvas){
        controller = Controller.getInstance();
        runAnimation = 0;
        countAnimation = 0;
        animation();
        this.canvas = canvas;
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        state = State.RUN;
        timer.start();
    }
    public void setPosition(double x, double y){
        if(position==null)
            position = new Position(x,y);
        else {
            position.setX(x);
            position.setY(y);
        }
    }
    public void paint(){
        onMove();
        if(state == State.IDLE)
            graphicsContext.drawImage(runs.get(runs.size()-1), position.getX(), position.getY(), horseWidth,horseHeight);
        else {
            graphicsContext.drawImage(runs.get(frameImg % 6), position.getX(), position.getY(), horseWidth, horseHeight);
            frameImg++;
        }
    }
    private void onMove(){
        if(state == State.RUN) {
            if(position.getX()<1000){
                if (countAnimation < animationSpeed.size()) {

                    if (runAnimation < (2520 / animationSpeed.size())) {
                        runAnimation += 40;
                    } else {
                        countAnimation++;
                        runAnimation = 0;
                    }
                    if (countAnimation != countSpeed.size()) {
                        position.setX(position.getX() + animationSpeed.get(countAnimation));
                    }
                } else {
                    countAnimation = ran.nextInt(5);
                }
            } else {
                raceTime = timer.stop();
                state = State.IDLE;
                controller.addFinishedHorse(name);
            }




        } else {
            frameImg = 0;
        }
    }
    private void animation(){
        minimunPath = 40;
        double animate = (double) minimunPath /100;
        animationSpeed = new ArrayList<>();
        countSpeed = new ArrayList<>();
        int i = 0;

        while (i!=100){
            int count = ran.nextInt(11,31);
            if((i+count)>100){
                count = 100-i;
                i = 100;
            } else {
                i += count;
            }
            countSpeed.add(count);
            animationSpeed.add(count*animate);
        }
    }

    public String getPercentage(){
        return format.format(winningPercentage)+"%";
    }

    public long getRaceTime() {
        return raceTime;
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

    public void setWinningPercentage(double totalRaces) {
        System.out.println("WINS"+wins);
        System.out.println("TotalRACES"+totalRaces);
        this.winningPercentage = (this.wins / totalRaces) * 100;
        System.out.println(winningPercentage);
    }

    public Image getImage(int i){
        return runs.get(i);
    }
}