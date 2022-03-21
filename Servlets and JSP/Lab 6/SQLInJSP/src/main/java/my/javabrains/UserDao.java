package my.javabrains;

public class UserDao {
    public String username;
    public String userFullName;

    UserDao(String username,String userFullName){
        this.username=username;
        this.userFullName=userFullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    };


    
}
