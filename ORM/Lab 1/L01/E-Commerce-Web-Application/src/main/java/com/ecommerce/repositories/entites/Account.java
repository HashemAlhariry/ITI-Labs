package com.ecommerce.repositories.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Account implements Serializable {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
@Column(name = "user_name")
private String userName;
private String address;
private String phone;
@Temporal(TemporalType.TIMESTAMP)
private Date birthday;
private String full_Name;
private String password;




public Account(String userName, String address, String phone, String fullName, String password) {
    this.userName = userName;
    this.address = address;
    this.phone = phone;
    this.full_Name = fullName;
    this.password = password;
}


public Account() {
}


public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}
public String getUserName() {
    return userName;
}
public void setUserName(String userName) {
    this.userName = userName;
}
public String getAddress() {
    return address;
}
public void setAddress(String address) {
    this.address = address;
}
public String getPhone() {
    return phone;
}
public void setPhone(String phone) {
    this.phone = phone;
}
public Date getBirthday() {
    return birthday;
}
public void setBirthday(Date birthday) {
    this.birthday = birthday;
}
public String getFullName() {
    return full_Name;
}
public void setFullName(String fullName) {
    this.full_Name = fullName;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}



}
