package userpackage.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import userpackage.dbconnection.DatabaseConnection;
import userpackage.user.User;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    private DatabaseConnection databaseConnection = new DatabaseConnection();
    private List<User> users= new ArrayList<>();

    private User user=null;
    private int currentUser=0;

    @FXML
    TextField id;
    @FXML
    TextField firstName;
    @FXML
    TextField middleName;
    @FXML
    TextField email;
    @FXML
    TextField phone;
    @FXML
    Button newUser;
    @FXML
    Button updateUser;
    @FXML
    Button deleteUser;
    @FXML
    Button firstUser;
    @FXML
    Button previousUser;
    @FXML
    Button nextUser;
    @FXML
    Button lastUser;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateAllUserFromDB();
    }

    public void updateText(User user) {

        id.setEditable(false);
        id.setText(user.getId());
        firstName.setText(user.getFirstName());
        middleName.setText(user.getMiddleName());
        email.setText(user.getEmail());
        phone.setText(user.getPhone());

    }

    public void updateAllUserFromDB(){

        Statement statement = null;

        try {
            statement = databaseConnection.getConnection().createStatement();
            ResultSet resultSet =
                    statement.executeQuery("SELECT * FROM jdbc.people");
            users.clear();
            while(resultSet.next()) {
                User user = new User(
                        resultSet.getString("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("middlename"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"));
                users.add(user);
                System.out.println(resultSet.getString("id"));
            }
            currentUser=0;
            if(users.size()!=0)
                 updateText(users.get(currentUser));
            else {
                id.setEditable(false);
                id.setText("");
                firstName.setText("");
                middleName.setText("");
                email.setText("");
                phone.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(){


            try {
                PreparedStatement ps = databaseConnection.getConnection().prepareStatement(
                        "INSERT INTO jdbc.people" +
                                "(firstname,middlename,email,phone)" +
                                "VALUES(?,?,?,?)");

                ps.setString(1, firstName.getText());
                ps.setString(2, middleName.getText());
                ps.setString(3, email.getText());
                ps.setString(4, phone.getText());
                ps.executeUpdate();
                updateAllUserFromDB();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        


    public void updateUser(){
            if(users.size()!=0) {
                try {
                    PreparedStatement ps = databaseConnection.getConnection().prepareStatement(
                            "update jdbc.people set  firstname = ? , middlename = ? , email = ? ,phone = ?" +
                                    "where id = ? "
                    );

                    ps.setString(1, firstName.getText());
                    ps.setString(2, middleName.getText());
                    ps.setString(3, email.getText());
                    ps.setString(4, phone.getText());
                    ps.setInt(5, Integer.parseInt(id.getText()));
                    ps.executeUpdate();
                    updateAllUserFromDB();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    public void deleteUser(){
        if(users.size()!=0) {
            try {
                PreparedStatement ps = databaseConnection.getConnection().prepareStatement(
                        "DELETE FROM jdbc.people " +
                                "where id = ? "
                );
                ps.setInt(1, Integer.parseInt(id.getText()));
                ps.executeUpdate();
                updateAllUserFromDB();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void getFirstUser(){
        currentUser=0;
        updateText(users.get(currentUser));
    }
    public void getLastUser(){
        if(currentUser==users.size())
            lastUser.setDisable(true);
        else
            lastUser.setDisable(
                    false
            );
        currentUser=users.size()-1;
        updateText(users.get(currentUser));
    }
    public void getPreviousUser(){
        if(currentUser >0){
            currentUser--;
            updateText(users.get(currentUser));
        }
    }
    public void getNextUser(){

        if(currentUser < users.size()-1){
            currentUser++;
            updateText(users.get(currentUser));
        }
    }

}