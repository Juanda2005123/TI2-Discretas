package com.example.control.part;

import com.example.control.Controller;
import com.example.control.screen.MainGameScreenController;
import com.example.exceptions.InvalidMoneyBetException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PartCantidadApostarController implements Initializable {

    @FXML
    private Label dineroJugador;

    @FXML
    private ImageView image;

    @FXML
    private TextField inputApuesta;

    @FXML
    private Label horseName;
    private MainGameScreenController mainGameScreenController;
    private int money;
    private Controller controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = Controller.getInstance();
        money = 0;
    }
    public void initAttributes(Image image, String name, MainGameScreenController mainGameScreenController){
        this.mainGameScreenController = mainGameScreenController;
        horseName.setText(name);
        this.image.setImage(image);
        this.dineroJugador.setText("Dinero de "+controller.getPlayer().getName()+": "+controller.getPlayer().getMoneySeparated());
    }
    @FXML
    void cancelarApuesta(ActionEvent event) {
        controller.setRacing(false);
        mainGameScreenController.handleCancelarApuestaPropia();
    }

    @FXML
    void hacerApuesta(ActionEvent event) {
        try{
            money = Integer.parseInt(inputApuesta.getText());
            InvalidMoneyBetException exception = new InvalidMoneyBetException(money,controller.getPlayer().getMoney());
            if(exception.isSend()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Invalid input");
                alert.setContentText(exception.getMsg());
                alert.showAndWait();
            } else {
                mainGameScreenController.handleApuestaPropia(horseName.getText(),money);
            }
        } catch (NumberFormatException e){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Invalid input");
            alert.setContentText("A number must be the input");
            alert.showAndWait();

        }

    }
    public String getHorseName(){
        return horseName.getText();
    }

}
