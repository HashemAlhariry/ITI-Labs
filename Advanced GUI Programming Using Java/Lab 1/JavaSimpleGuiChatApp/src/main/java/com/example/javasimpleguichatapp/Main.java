package com.example.javasimpleguichatapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {

        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("profile-view.fxml"));
            Scene scene = new Scene(root, 600, 400);
            scene.getStylesheets().add((new File("src/main/resources/com/example/styles/profile-view.css")).toURI().toString());
            stage.setTitle("JETS Chatting App");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}