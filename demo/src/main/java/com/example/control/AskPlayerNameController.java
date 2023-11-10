package com.example.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AskPlayerNameController implements Initializable {

    @FXML
    private TextField playerName;

    @FXML
    void iniciarJuego(ActionEvent event) {
        Stage stage = (Stage) this.playerName.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public String getPlayerName(){
        return playerName.getText();
    }
}
