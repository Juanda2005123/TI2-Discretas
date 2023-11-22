package com.example.control.screen;

import com.example.control.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AskGameAlgorithmScreenController implements Initializable {

    @FXML
    private Label label;
    private MainGameScreenController parent;
    private Controller controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = Controller.getInstance();
    }
    public void setParent(MainGameScreenController mainGameScreenController){
        parent = mainGameScreenController;
    }
    @FXML
    void directedDijkstra(ActionEvent event) {
        parent.handleDirectedDijkstra();
        close();
    }

    @FXML
    void directedFloyd(ActionEvent event) {
        parent.handleDirectedFloyd();
        close();
    }

    @FXML
    void undirectedDijkstra(ActionEvent event) {
        parent.handleUndirectedDijkstra();
        close();
    }

    @FXML
    void undirectedFloyd(ActionEvent event) {
        parent.handleUndirectedFloyd();
        close();
    }
    private void close(){
        controller.setRacing(true);
        Stage stage = (Stage) this.label.getScene().getWindow();
        stage.close();
    }

}
