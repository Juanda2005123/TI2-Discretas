package com.example.control.screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartGameScreenController implements Initializable {

    @FXML
    private HBox hBox;
    @FXML
    private Button botton;


    @FXML
    void jugar(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/vista/screen/ask-player-name-screen.fxml"));
            Parent root = loader.load();

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene mainScene = new Scene(root);

            currentStage.setX(660);
            currentStage.setY(340);

            currentStage.setScene(mainScene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

