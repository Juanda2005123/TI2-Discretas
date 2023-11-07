package com.example.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ExecutableApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ExecutableApplication.class.getResource("/com/example/vista/start-game-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1728, 972); //90% Full HD
        stage.setTitle("Main page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}