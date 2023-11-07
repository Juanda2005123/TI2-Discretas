package com.example.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PartResultadosAnterioresController implements Initializable {

    @FXML
    private Label nombre;

    @FXML
    private Label porcentajeVictoria;

    @FXML
    private Label victorias;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initAttributes(String name, String percent, String wins){
        nombre.setText(name);
        porcentajeVictoria.setText(percent);
        victorias.setText(wins);
    }
}
