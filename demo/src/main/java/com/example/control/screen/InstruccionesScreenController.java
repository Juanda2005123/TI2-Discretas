package com.example.control.screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InstruccionesScreenController implements Initializable {
    @FXML
    private Button cerrarButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void cerrar(ActionEvent event) {
        Stage stage = (Stage) this.cerrarButton.getScene().getWindow();
        stage.close();
    }
}
