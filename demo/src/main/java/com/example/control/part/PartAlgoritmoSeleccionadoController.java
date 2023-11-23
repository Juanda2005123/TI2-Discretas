package com.example.control.part;

import com.example.control.Controller;
import com.example.control.screen.MainGameScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class PartAlgoritmoSeleccionadoController implements Initializable {
    @FXML
    private Label horseName;

    @FXML
    private ImageView image;

    @FXML
    private Label outputApuesta;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void initAttributes(String horseName, Image image, String apuesta){
        this.horseName.setText(horseName);
        this.image.setImage(image);
        outputApuesta.setText(apuesta);
    }
}
