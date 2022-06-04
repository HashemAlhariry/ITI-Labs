package com.example.sample.controller;

import gov.iti.backend.services.EmployeeService.EmployeeDto;
import gov.iti.backend.services.EmployeeService.EmployeeService;
import gov.iti.backend.services.EmployeeService.EmployeeServiceImplService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    private List<EmployeeDto> employees= new ArrayList<>();
    final EmployeeServiceImplService employeeService = new EmployeeServiceImplService();


    //private User user=null;
    private int currentUser=0;

    @FXML
    TextField id;
    @FXML
    TextField firstName;
    @FXML
    TextField age;
    @FXML
    TextField department;


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
         getAllEmployees();
    }

    public void updateText(EmployeeDto employeeDto){
        id.setEditable(false);
        String empId =  String.valueOf(employeeDto.getId());
        id.setText(empId);
        firstName.setText(employeeDto.getFirstName());
        age.setText(employeeDto.getAge());
        department.setText(employeeDto.getDepartment());
    }
    public void getAllEmployees(){
        EmployeeService employeeServiceImpl = employeeService.getEmployeeServiceImplPort();
        employees = employeeServiceImpl.getAllEmployees();
        if(employees.size()>0){
            updateText(employees.get(currentUser));
        }
    }

    public void updateUser(){


        employees.get(currentUser).setAge(age.getText());
        employees.get(currentUser).setFirstName(firstName.getText());
        employees.get(currentUser).setDepartment(department.getText());


        System.out.println(employees.get(currentUser).getId());
        System.out.println(employees.get(currentUser).getFirstName());
        System.out.println(employees.get(currentUser).getAge());
        System.out.println(employees.get(currentUser));


        if(employees.size()!=0) {
            EmployeeService employeeServiceImp = employeeService.getEmployeeServiceImplPort();
            employeeServiceImp.updateEmployee(employees.get(currentUser));
        }
    }

    public void deleteUser(){
        if(employees.size()!=0) {
            EmployeeService employeeServiceImp = employeeService.getEmployeeServiceImplPort();
            employeeServiceImp.deleteEmployee(employees.get(currentUser).getId());
            employees.remove(currentUser);
            getFirstUser();
        }
    }
    public void getFirstUser(){
        currentUser=0;
        updateText(employees.get(currentUser));
    }
    public void getPreviousUser(){
        if(currentUser >0){
            currentUser--;
            updateText(employees.get(currentUser));
        }
    }
    public void getNextUser(){
        if(currentUser < employees.size()-1){
            currentUser++;
            updateText(employees.get(currentUser));
        }
    }
    public void getLastUser(){
        if(currentUser==employees.size())
            lastUser.setDisable(true);
        else
            lastUser.setDisable(false);

        currentUser=employees.size()-1;
        updateText(employees.get(currentUser));
    }


    /*

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








    */
}
