package com.example.urlurlconnectionwebview;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController  implements Initializable {


    @FXML
    private WebView webView;
    private String link = "https://stackoverflow.com";
    private WebEngine engine;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        engine= webView.getEngine();
        engine.loadContent(UrlConn.getContent(link));
    }
}