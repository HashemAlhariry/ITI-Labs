package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","pluralsight");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from people");
            while (resultSet.next()){
                System.out.println(resultSet.getString("id")+" "+ resultSet.getString("firstname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
