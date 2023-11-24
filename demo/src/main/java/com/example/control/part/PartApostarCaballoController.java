package com.example.control.part;

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

public class PartApostarCaballoController implements Initializable {
    public Label nombreCaballo;
    public Button botonApostar;
    @FXML
    private ImageView image;

    private MainGameScreenController mainGameScreenController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void initAttributes(Image image, String name, MainGameScreenController mainGameScreenController){
        this.image.setImage(image);
        nombreCaballo.setText(name);
        this.mainGameScreenController = mainGameScreenController;
    }

    @FXML
    void apostar(ActionEvent event) {
        System.out.println("La letra se hace chiquita, revisar");
        mainGameScreenController.handleApostar(nombreCaballo.getText());
    }
}
