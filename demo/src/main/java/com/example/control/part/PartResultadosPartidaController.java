package com.example.control.part;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class PartResultadosPartidaController implements Initializable {

    @FXML
    private Label cuartoCarrera;

    @FXML
    private Label cuartoSegundos;

    @FXML
    private Label ganadorCarrera;

    @FXML
    private Label ganadorSegundos;

    @FXML
    private Label quintoCarrera;

    @FXML
    private Label quintoSegundos;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void initAttributes(String ganador, String ganadorSeg,
                               String segundo, String segundoSeg,
                               String tercero, String terceroSeg,
                               String cuarto, String cuartoSeg,
                               String quinto, String quintoSeg){
        ganadorCarrera.setText(ganador);
        ganadorSegundos.setText(ganadorSeg);
        segundoCarrera.setText(segundo);
        segundoSegundos.setText(segundoSeg);
        terceroCarrera.setText(tercero);
        terceroSegundos.setText(terceroSeg);
        cuartoCarrera.setText(cuarto);
        cuartoSegundos.setText(cuartoSeg);
        quintoCarrera.setText(quinto);
        quintoSegundos.setText(quintoSeg);
    }
}
