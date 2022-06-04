package com.iti.jets;


import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import java.io.Serializable;

/**
 *
 * @author hashemalhariry
 */

@ManagedBean(name = "UserBean")
@SessionScoped
public class UserBean implements Serializable {

    String userName = "";
    String greetings ="";
    String password = "";
    
    public UserBean() {
        
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public String getGreetings() {
        return greetings;
    }

    public void setGreetings(String greetings) {
        this.greetings = greetings;
    }

}
