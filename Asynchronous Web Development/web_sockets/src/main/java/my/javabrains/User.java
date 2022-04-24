package my.javabrains;

public class User {

    public String name;
    public String gender;

    public User(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public User() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
