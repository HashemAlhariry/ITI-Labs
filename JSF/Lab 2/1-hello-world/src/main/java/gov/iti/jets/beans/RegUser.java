 
package gov.iti.jets.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import java.io.Serializable;


@ManagedBean(name = "reguser")
@SessionScoped
public class RegUser implements Serializable {

    private String name="";
    private String password="";
    private CreditCard credit;
    private String email="";
    private String birthDay="";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public CreditCard getCredit() {
        return credit;
    }

    public void setCredit(CreditCard credit) {
        this.credit = credit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

}
