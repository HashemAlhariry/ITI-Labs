package com.example.javasimpleguichatapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileViewController  {


    private Scene scene;
    private Parent root;
    private final FileChooser fileChooser = new FileChooser();

    @FXML
    private TextField textFieldName;
    @FXML
    private Button choosePicture;
    @FXML
    private ImageView defaultImageView;




    @FXML
    public void chatScreenScene(ActionEvent event) throws IOException {

        String name= textFieldName.getText();
        System.out.println(name);

        FXMLLoader loader= new FXMLLoader(getClass().getResource("chat-screen.fxml"));
        root=loader.load();

        ChatScreenController chatScreenController = loader.getController();
        chatScreenController.setLabelText(name);
        chatScreenController.setProfileImage(defaultImageView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add((new File("src/main/resources/com/example/styles/profile-view.css")).toURI().toString());
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void loadPicture()
    {

        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add( new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.gif","*.jpeg"));
        File file =  fileChooser.showOpenDialog(null);
        if(file!=null){
            defaultImageView.setImage(new Image(file.toURI().toString()));
        }else{
            System.out.println("InvalidImage");
        }

    }



}