package gov.iti.jets.bean.dao.impl;


import gov.iti.jets.bean.dao.AccountDao;


public class AccountDaoImpl implements AccountDao {

    private String userName;
    private String password;

    public AccountDaoImpl() {
    }

    @Override
    public void GetAllAccounts() {
       System.out.println("Hello from Account Dao Impl");
    }


    public void init(){
        System.out.println("From Account Dao Impl init method");
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
