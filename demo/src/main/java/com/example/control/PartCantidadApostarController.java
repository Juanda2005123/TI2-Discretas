package com.example.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class PartCantidadApostarController implements Initializable {

    @FXML
    private Button apostarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private ImageView image;

    @FXML
    private TextField inputApuesta;

    @FXML
    private Label horseName;
    private MainGameScreenController mainGameScreenController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void initAttributes(Image image, String name, MainGameScreenController mainGameScreenController){
        this.mainGameScreenController = mainGameScreenController;
        horseName.setText(name);
        this.image.setImage(image);
    }
    @FXML
    void cancelarApuesta(ActionEvent event) {
        mainGameScreenController.handleCancelarApuestaPropia();
    }

    @FXML
    void hacerApuesta(ActionEvent event) {
        mainGameScreenController.handleApuestaPropia(horseName.getText(),inputApuesta.getText());
    }

}
