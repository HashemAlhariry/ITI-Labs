package gov.iti.jets.bean.classpathscanning.dao.impl;

import org.springframework.stereotype.Repository;

import gov.iti.jets.bean.classpathscanning.dao.AccountDao;

@Repository
public class AccountDaoImpl implements AccountDao {

    private String userName;
    private String password;

    @Override
    public void GetAllAccounts() {
       System.out.println("Hello from Account Dao Impl");
    }


    public void setUserName(String userName){
        this.userName =userName;
    }
    public String getUserName(){
        return userName;
    }
    

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    @Override
    public String toString() {
        return "AccountDaoImpl{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
