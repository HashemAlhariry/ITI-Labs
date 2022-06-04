package gov.iti.jets.lab;

import java.util.List;

public class UserInfo {
    public String auther;
    public String userName;
    public String phone;
    public String email;
    public List<PostInfo> posts;

    public UserInfo(String auther, String userName, String phone, String email, List<PostInfo> posts) {
        this.auther = auther;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.posts = posts;
    }

}
