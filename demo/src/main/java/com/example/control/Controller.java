package com.example.control;

import com.example.model.Horse;
import com.example.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static Controller controller;
    private List<Horse> horseList;
    private int totalRaces;

    private boolean firstRace;
    private Player player;

    public static Controller getInstance(){
        if(controller==null) {
            controller = new Controller();
        }
        return controller;
    }
    public List<Horse> getHorseList(){
        return horseList;
    }

    public Controller(){

        horseList = new ArrayList<>();
        totalRaces = 0;
        startHorses();
        firstRace = true;
    }

    public void setPlayer(String name){
        player = new Player(name);
    }



    public boolean isFirstRace(){
        return firstRace;
    }

    private void startHorses(){
        horseList.add(new Horse("Spirit","Red1"));
        horseList.add(new Horse("Morgan","Orange5"));
        horseList.add(new Horse("Pegasus","Grey3"));
        horseList.add(new Horse("Red Rum","Black2"));
        horseList.add(new Horse("Bullseye","Brown4"));
    }

    public Horse getHorse(int i){
        return horseList.get(i);
    }

}
