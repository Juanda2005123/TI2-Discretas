package com.example.control.screen;

import com.example.control.Controller;
import com.example.exceptions.InvalidPlayerNameException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AskPlayerNameScreenController implements Initializable {

    @FXML
    private TextField playerName;
    @FXML
    void instrucciones(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/vista/screen/instrucciones-screen.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @FXML
    void iniciarJuego(ActionEvent event) {
        InvalidPlayerNameException exception = new InvalidPlayerNameException(playerName.getText());

        if(exception.isSend()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Invalid input");
            alert.setContentText(exception.getMsg());
            alert.showAndWait();
        } else {
            try{
                Controller controller = Controller.getInstance();
                controller.setPlayer(playerName.getText());

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/vista/screen/main-game-screen.fxml"));
                Parent root = loader.load();

                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene mainScene = new Scene(root);

                currentStage.setX(85);
                currentStage.setY(14);

                currentStage.setScene(mainScene);
            } catch (IOException e){
                throw new RuntimeException(e.getMessage());
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public String getPlayerName(){
        return playerName.getText();
    }
}
