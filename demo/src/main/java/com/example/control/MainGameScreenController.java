package com.example.control;

import com.example.model.Horse;
import com.example.screens.ScreenA;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainGameScreenController implements Initializable {

    @FXML
    private VBox apostarCaballo;

    @FXML
    private Label cuartoCarrera;

    @FXML
    private Label cuartoSegundos;

    @FXML
    private Label ganadorCarrera;

    @FXML
    private Label ganadorSegundos;
    @FXML
    private VBox juego;

    @FXML
    private Label quintoCarrera;

    @FXML
    private Label quintoSegundos;

    @FXML
    private VBox resultadosAnteriores;

    @FXML
    private Label resultadosNumero;

    @FXML
    private VBox resultadosPartida;

    @FXML
    private Label segundoCarrera;

    @FXML
    private Label segundoSegundos;

    @FXML
    private Label terceroCarrera;

    @FXML
    private Label terceroSegundos;

    @FXML
    private VBox vBoxtablaResultados;

    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private ScreenA screenA;

    private Controller controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = Controller.getInstance();

        this.graphicsContext = this.canvas.getGraphicsContext2D();
        screenA = new ScreenA(canvas,controller.getHorseList());
        screenA.paintBlack();

        fillTablaResultadosCaballos();
        fillApostarCaballo();

        if(controller.isFirstRace()){
            vBoxtablaResultados.getChildren().clear();
            vBoxtablaResultados.setStyle("-fx-background-color: #141414");
        }

    }
    private void fillTablaResultadosCaballos(){
        for (int i = 0; i < 5; i++){
            try{
                Horse horse = controller.getHorse(i);
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/example/vista/part-resultados-anteriores.fxml"));

                HBox hBox = loader.load();
                PartResultadosAnterioresController tic = loader.getController();

                tic.initAttributes(horse.getName(),horse.getPercentage(),horse.getWins()+"");
                resultadosAnteriores.getChildren().add(hBox);
            } catch (IOException e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }
    private void fillApostarCaballo(){
        apostarCaballo.getChildren().clear();
        for (int i = 0; i < 5; i++){
            try{
                Horse horse = controller.getHorse(i);
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("/com/example/vista/part-apostar-caballo.fxml"));

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
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/com/example/vista/part-cantidad-apostar.fxml"));

                    VBox h = loader.load();

                    PartCantidadApostarController tic = loader.getController();
                    tic.initAttributes(horse.getImage(5), horse.getName(),this);

                    apostarCaballo.getChildren().add(h);
                } catch (IOException e){
                    throw new RuntimeException(e.getMessage());
                }


            }
        }
    }
    public void handleCancelarApuestaPropia(){
        fillApostarCaballo();
    }
    public void handleApuestaPropia(String horseName, String apuesta){
        int cantidadApostada = Integer.parseInt(apuesta);
        for(int i = 0; i < 5; i++){
            Horse horse = controller.getHorse(i);
            if(horseName.equals(horse.getName())){
                apostarCaballo.getChildren().clear();
                try{
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/com/example/vista/part-apuesta-realizada.fxml"));

                    VBox h = loader.load();

                    PartApuestaRealizadaController tic = loader.getController();
                    tic.initAttributes(horse.getName(),horse.getImage(5),cantidadApostada);

                    apostarCaballo.getChildren().add(h);

                    startRace();
                } catch (IOException e){
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }
    private void startRace(){

    }
}
