/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gov.iti.jets.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import java.io.Serializable;

/**
 *
 * @author EEC
 */

@ManagedBean(name = "user")
@SessionScoped
public class UserBean implements Serializable {

    private String name="";
    private String password="";
    private String greeting="";

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newValue) {
        password = newValue;
    }

     public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

}
