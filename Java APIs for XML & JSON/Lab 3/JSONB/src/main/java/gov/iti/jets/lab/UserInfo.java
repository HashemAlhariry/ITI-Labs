package gov.iti.jets.lab;

import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable{
    public String name;
    public String userName;
    public String phone;
    public String email;
    public java.util.List<PostInfo> posts;

    public UserInfo(String name, String userName, String phone, String email, List<PostInfo> posts) {
        this.name = name;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.posts = posts;
    }
    public UserInfo(){}
    @Override
    public String toString() {
        return "UserInfo [email=" + email + ", name=" + name + ", phone=" + phone + ", posts=" + posts + ", userName="
                + userName + "]";
    }
    
}
