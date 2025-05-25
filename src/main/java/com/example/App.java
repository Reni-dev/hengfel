/*
* File: App.java
* Author: Hanák Renáta
* Copyright: 2025, Hanák Renáta
* Group: Szoft 1/N
* Date: 2025-05-25
* Github: https://github.com/reni-dev/
* Licenc: MIT
*/


package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Stage _stage;

    @Override
    public void start(Stage stage) throws IOException {
        _stage = stage;
        scene = new Scene(loadFXML("MainScene"), 1180, 800);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}