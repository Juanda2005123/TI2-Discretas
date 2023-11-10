package com.example.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class PartApuestaRealizadaController implements Initializable {

    @FXML
    private Label horseName;

    @FXML
    private ImageView image;

    @FXML
    private Label outputApuesta;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initAttributes(String horseName, Image image, int apuesta){
        this.horseName.setText(horseName);
        this.image.setImage(image);
        outputApuesta.setText(apuesta+"");
    }
}
