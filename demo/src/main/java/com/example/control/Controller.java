package com.example.control;

import com.example.control.screen.MainGameScreenController;
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
    private MainGameScreenController mainGameScreenController;

    public static Controller getInstance(){
        if(controller==null) {
            controller = new Controller();
        }
        return controller;
    }


    public void setMainGameScreenController(MainGameScreenController mainGameScreenController) {
        this.mainGameScreenController = mainGameScreenController;
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

        if(podiumHorse.size()==5) {
            totalRaces++;
            racing = false;
            String[][] ma = new String[5][2];
            for (int i = 0; i < 5 ; i++){
                for(int j = 0 ; j < horseList.size() ; j++){
                    if(podiumHorse.get(i).equals(horseList.get(j).getName())){
                        ma[i][0] = horseList.get(j).getName();

                        ma[i][1] = "("+(double) horseList.get(j).getRaceTime()/1000+" segundos)";
                    }
                }
            }
            for(int i = 0 ; i < horseList.size() ; i++){
                if(podiumHorse.get(0).equals(horseList.get(i).getName())){
                    horseList.get(i).setWins(horseList.get(i).getWins()+1);
                }
            }
            for(var horse : horseList){
                horse.setWinningPercentage(totalRaces);
            }
            mainGameScreenController.fillTablaResultados(ma[0][0],ma[0][1],
                    ma[1][0],ma[1][1],ma[2][0],ma[2][1],ma[3][0],ma[3][1],
                    ma[4][0],ma[4][1]);

            mainGameScreenController.fillTablaResultadosCaballos();
            mainGameScreenController.fillApostarCaballo();
            boolean first = podiumHorse.get(0).equals(player.getBet().getHorseName());
            boolean second = podiumHorse.get(1).equals(player.getBet().getHorseName());
            mainGameScreenController.betInformation(player.getBet(), first, second);

            for(int i = 0 ; i < 5 ; i++){
                podiumHorse.remove(0);
            }
            firstRace = false;
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

    public static Controller getController() {
        return controller;
    }

    public static void setController(Controller controller) {
        Controller.controller = controller;
    }

    public void setHorseList(List<Horse> horseList) {
        this.horseList = horseList;
    }

    public int getTotalRaces() {
        return totalRaces;
    }

    public void setTotalRaces(int totalRaces) {
        this.totalRaces = totalRaces;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<String> getPodiumHorse() {
        return podiumHorse;
    }

    public void setPodiumHorse(ArrayList<String> podiumHorse) {
        this.podiumHorse = podiumHorse;
    }

    public MainGameScreenController getMainGameScreenController() {
        return mainGameScreenController;
    }
}
