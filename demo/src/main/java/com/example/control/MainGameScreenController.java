package com.example.control;

import com.example.model.Horse;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainGameScreenController implements Initializable {

    @FXML
    public Canvas canvas;
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

    private Controller controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = Controller.getInstance();
        for(int i = 0; i < 5 ; i++){

            try {
                Horse horse = controller.getHorse(i);
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/example/vista/part-resultados-anteriores.fxml"));

                HBox hBox = loader.load();
                PartResultadosAnterioresController tic = loader.getController();

                tic.initAttributes(horse.getName(),horse.getPercentage(),horse.getWins()+"");
                resultadosAnteriores.getChildren().add(hBox);

                if(controller.isFirstRace()){
                    vBoxtablaResultados.getChildren().clear();
                    vBoxtablaResultados.setStyle("-fx-background-color: #141414");
                }

                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("/com/example/vista/part-apostar-caballo.fxml"));

                HBox h = loader1.load();

                PartApostarCaballoController tic1 = loader1.getController();
                tic1.initAttributes(horse.getImage(5), horse.getName());

                apostarCaballo.getChildren().add(h);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
