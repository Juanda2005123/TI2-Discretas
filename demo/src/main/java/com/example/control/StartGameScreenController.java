package com.example.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class StartGameScreenController {

    @FXML
    private HBox hBox;
    @FXML
    private Button botton;


    @FXML
    void jugar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/vista/main-game-screen.fxml"));
            Parent root = loader.load();

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene mainScene = new Scene(root);
            currentStage.setScene(mainScene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

