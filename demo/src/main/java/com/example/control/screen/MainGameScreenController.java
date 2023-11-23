package com.example.control.screen;

import com.example.control.*;
import com.example.control.part.*;
import com.example.model.Bet;
import com.example.model.Horse;
import com.example.screens.ScreenA;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainGameScreenController implements Initializable {

    @FXML
    private VBox apostarCaballo;

    @FXML
    private VBox juego;



    @FXML
    private VBox resultadosAnteriores;

    @FXML
    private Label resultadosNumero;

    @FXML
    private VBox resultadosPartida;

    @FXML
    private VBox vBoxtablaResultados;

    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private ScreenA screenA;
    private Controller controller;
    private PartCantidadApostarController partCantidadApostarController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = Controller.getInstance();

        this.graphicsContext = this.canvas.getGraphicsContext2D();


        fillTablaResultadosCaballos();
        fillApostarCaballo();
/**
        if(controller.isFirstRace()){
            resultadosPartida.getChildren().remove(1);
            resultadosPartida.setStyle("-fx-background-color: #141414");
        }
 */
        partCantidadApostarController = null;

    }
    public void fillTablaResultadosCaballos(){
        resultadosAnteriores.getChildren().clear();
        for (int i = 0; i < 5; i++){
            try{
                Horse horse = controller.getHorse(i);
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/example/vista/part/part-resultados-anteriores.fxml"));

                HBox hBox = loader.load();
                PartResultadosAnterioresController tic = loader.getController();

                tic.initAttributes(horse.getName(),horse.getPercentage(),horse.getWins()+"");
                resultadosAnteriores.getChildren().add(hBox);
            } catch (IOException e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }
    public void fillApostarCaballo(){
        apostarCaballo.getChildren().clear();
        for (int i = 0; i < 5; i++){
            try{
                Horse horse = controller.getHorse(i);
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("/com/example/vista/part/part-apostar-caballo.fxml"));

                HBox h = loader1.load();

                PartApostarCaballoController tic1 = loader1.getController();
                tic1.initAttributes(horse.getImage(5), horse.getName(),this);

                apostarCaballo.getChildren().add(h);
            } catch (IOException e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }


    public void handleApostar(String horseName){
        for (int i = 0; i < 5 ; i++){
            Horse horse = controller.getHorse(i);
            if(horseName.equals(horse.getName())){
                apostarCaballo.getChildren().clear();
                try{
                    controller.setRacing(true);
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/com/example/vista/part/part-cantidad-apostar.fxml"));

                    VBox h = loader.load();

                    partCantidadApostarController = loader.getController();
                    partCantidadApostarController.initAttributes(horse.getImage(5), horse.getName(),this);

                    apostarCaballo.getChildren().add(h);
                } catch (IOException e){
                    throw new RuntimeException(e.getMessage());
                }


            }
        }
    }

    public void handleCancelarApuestaPropia(){
        partCantidadApostarController = null;
        fillApostarCaballo();
    }
    public void handleApuestaPropia(String horseName, int cantidadApostada) {
        for(int i = 0; i < 5; i++){
            Horse horse = controller.getHorse(i);
            if(horseName.equals(horse.getName())){
                apostarCaballo.getChildren().clear();
                try{
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/com/example/vista/part/part-apuesta-realizada.fxml"));

                    VBox h = loader.load();

                    PartApuestaRealizadaController tic = loader.getController();
                    tic.setParent(this);
                    tic.initAttributes(horse.getName(),horse.getImage(5),cantidadApostada);

                    apostarCaballo.getChildren().add(h);
                    controller.playerBettingMoney(cantidadApostada);
                } catch (IOException e){
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }
    @FXML
    void recargarDinero(ActionEvent event) {
        try{
            if(controller.isRacing()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Invalid recharge");
                alert.setContentText("Recharges are not possible in this moment");
                alert.showAndWait();
            }else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/vista/screen/recargar-dinero-screen.fxml"));

                Parent root = loader.load();
                RecargarDineroScreenController tic = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                int money = tic.getMoney();
                if(money==0){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText(null);
                    alert.setTitle("Invalid input");
                    alert.setContentText("There was an error in the recharge of money");
                    alert.showAndWait();
                } else {
                    controller.rechargePlayerMoney(money);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Successful recharge");
                    alert.setContentText("$"+money+" were recharged");
                    alert.showAndWait();
                }
            }


        } catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public void handleIniciarJuego(String horseName, Image image, String outputApuesta){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/vista/screen/ask-game-algorithm-screen.fxml"));

            Parent root = loader.load();
            AskGameAlgorithmScreenController askGameAlgorithmScreenController = loader.getController();
            askGameAlgorithmScreenController.setParent(this);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            handleAlgoritmoSeleccionado(horseName, image, outputApuesta);

        } catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public void handleAlgoritmoSeleccionado(String horseName, Image image, String outputApuesta) {

        apostarCaballo.getChildren().clear();
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/vista/part/part-algoritmo-seleccionado.fxml"));

            VBox h = loader.load();

            PartAlgoritmoSeleccionadoController tic = loader.getController();
            tic.initAttributes(horseName,image,outputApuesta);

            apostarCaballo.getChildren().add(h);
            startRace();
        } catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public void handleDirectedFloyd(){
        ArrayList<Horse> horses = (ArrayList<Horse>) controller.getHorseList();
        for (var horse : horses){
            horse.newGraphDirected();
            horse.graphfloydWarshall();
        }
    }
    public void handleUndirectedFloyd(){
        ArrayList<Horse> horses = (ArrayList<Horse>) controller.getHorseList();
        for (var horse : horses){
            horse.newGraphUndirected();
            horse.graphfloydWarshall();
        }
    }
    public void handleDirectedDijkstra(){
        ArrayList<Horse> horses = (ArrayList<Horse>) controller.getHorseList();
        for (var horse : horses){
            horse.newGraphDirected();
            horse.graphDijkstra();
        }
    }
    public void handleUndirectedDijkstra(){
        ArrayList<Horse> horses = (ArrayList<Horse>) controller.getHorseList();
        for (var horse : horses){
            horse.newGraphUndirected();
            horse.graphDijkstra();
        }

    }


    private void startRace(){
        controller.setMainGameScreenController(this);
        screenA = new ScreenA(canvas, controller.getHorseList());
        for (var horse:
             controller.getHorseList()) {
            horse.startHorse(canvas);
        }
        new Thread(() -> {
            while (controller.isRacing()) {
                Platform.runLater(() -> {
                    screenA.paint();
                });

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void fillTablaResultados(String ganador, String ganadorSeg,
                                    String segundo, String segundoSeg,
                                    String tercero, String terceroSeg,
                                    String cuarto, String cuartoSeg,
                                    String quinto, String quintoSeg){


        if(!controller.isFirstRace()){
            resultadosPartida.getChildren().remove(1);

        }
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/vista/part/part-resultados-partida.fxml"));

            VBox h = loader.load();

            PartResultadosPartidaController tic = loader.getController();
            tic.initAttributes(ganador, ganadorSeg,
                    segundo, segundoSeg,
                    tercero, terceroSeg,
                    cuarto, cuartoSeg,
                    quinto, quintoSeg);

            resultadosNumero.setText("Resultados Carrera #"+controller.getTotalRaces());
            resultadosPartida.getChildren().add(h);
        } catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public void betInformation(Bet bet, boolean first, boolean second){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Results of the bet");
        if(first){
            bet.winMoney();
            alert.setContentText(controller.getPlayer().getName()+" has earned $"+bet.getMoney());
        } else if (second){
            bet.secondMoney();
            alert.setContentText(controller.getPlayer().getName()+" has earned $"+bet.getMoney());
        } else {
            alert.setContentText(controller.getPlayer().getName()+" has lost $"+bet.getMoney());
            bet.loseMoney();
        }
        controller.rechargePlayerMoney(bet.getMoney());
        alert.showAndWait();
    }



}
