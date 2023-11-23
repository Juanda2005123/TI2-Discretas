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
    private boolean racing;
    private Player player;
    private ArrayList<String> podiumHorse;

    public static Controller getInstance(){
        if(controller==null) {
            controller = new Controller();
        }
        return controller;
    }


    private Controller(){
        podiumHorse = new ArrayList<>();
        racing = false;
        horseList = new ArrayList<>();
        totalRaces = 0;
        startHorses();
        firstRace = true;
    }

    public void setPlayer(String name){
        player = new Player(name);
    }
    public void rechargePlayerMoney(int money){
        player.setMoney(player.getMoney()+money);
    }
    public void playerBettingMoney(int betMoney){
        player.setMoney(player.getMoney()-betMoney);
    }
    public Player getPlayer(){
        return player;
    }
    public void addFinishedHorse(String name){
        podiumHorse.add(name);
        if(podiumHorse.size()==5){
            racing = false;
        }
    }

    public List<Horse> getHorseList(){
        return horseList;
    }

    public void setFirstRace(boolean firstRace) {
        this.firstRace = firstRace;
    }

    public boolean isRacing() {
        return racing;
    }

    public void setRacing(boolean racing) {
        this.racing = racing;
    }

    public boolean isFirstRace(){
        return firstRace;
    }

    private void startHorses(){
        horseList.add(new Horse("Spirit","Red1"));
        horseList.add(new Horse("Duncan","Orange5"));
        horseList.add(new Horse("Pegasus","Grey3"));
        horseList.add(new Horse("Red Rum","Black2"));
        horseList.add(new Horse("Bullseye","Brown4"));
    }

    public Horse getHorse(int i){
        return horseList.get(i);
    }

}
