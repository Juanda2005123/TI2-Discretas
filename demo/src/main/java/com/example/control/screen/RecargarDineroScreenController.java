package com.example.control.screen;

import com.example.exceptions.InvalidMoneyRechargeException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RecargarDineroScreenController implements Initializable {

    @FXML
    private TextField dinero;
    private int money;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        money = 0;
    }

    @FXML
    void recargar(ActionEvent event) {
        try{
            money = Integer.parseInt(dinero.getText());
            InvalidMoneyRechargeException exception = new InvalidMoneyRechargeException(money);
            if(exception.isSend()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Invalid input");
                alert.setContentText(exception.getMsg());
                alert.showAndWait();
            } else {

                Stage stage = (Stage) this.dinero.getScene().getWindow();
                stage.close();
            }
        } catch (NumberFormatException e){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Invalid input");
            alert.setContentText("A number must be the input");
            alert.showAndWait();

        }

    }

    public int getMoney(){
        return money;
    }


}
