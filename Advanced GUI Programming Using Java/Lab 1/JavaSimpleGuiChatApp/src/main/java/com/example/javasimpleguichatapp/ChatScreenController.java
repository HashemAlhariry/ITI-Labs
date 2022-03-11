package com.example.javasimpleguichatapp;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.net.URL;
import java.util.Random;

import java.util.ResourceBundle;

public class ChatScreenController implements Initializable {

    @FXML
    private ImageView profileImage;
    @FXML
    private Label labelText;
    @FXML
    private TextField textFieldChat;
    @FXML
    private VBox vbox_messages;
    @FXML
    private ScrollPane sp_main;

    public void setProfileImage(ImageView image) {
        profileImage.setImage(image.getImage());
    }

    public void setLabelText(String text){
        labelText.setText(text);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vbox_messages.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                sp_main.setVvalue((Double) t1);
            }
        });
    }
    @FXML
    public void onEnter(ActionEvent e){

        if(Math.random()<=0.5 && !textFieldChat.getText().isEmpty()) {

            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setPadding(new Insets(5, 5, 5, 10));
            Text text = new Text(textFieldChat.getText());
            TextFlow textFlow = new TextFlow(text);
            textFlow.setStyle(
                    "-fx-background-color:rgb(233,233,235); " +
                            "-fx-background-radius: 20px;");
            textFlow.setPadding(new Insets(5, 10, 5, 10));
            hBox.getChildren().add(textFlow);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    vbox_messages.getChildren().add(hBox);
                }
            });

        }

        else if(!textFieldChat.getText().isEmpty()){
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_RIGHT);
            hBox.setPadding(new Insets(5,5,5,10));
            Text text = new Text(textFieldChat.getText());
            TextFlow textFlow = new TextFlow(text);
            textFlow.setStyle(
                     "-fx-background-color: #84C188;" +
                    " -fx-background-radius: 20px;" );
            textFlow.setPadding(new Insets(5,10,5,10));
            text.setFill(Color.color(0.934,0.945,0.996));
            hBox.getChildren().add(textFlow);
            vbox_messages.getChildren().add(hBox);

        }

        textFieldChat.clear();
    }
}


