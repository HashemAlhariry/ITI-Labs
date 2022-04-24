package my.javabrains;


public class Message {
    
    public User user;
    public String message;
    public String date;
    public Message() {

    }

    public Message( String message ,User user ,String date) {

        this.user = user;
        this.message = message;
        this.date=date;

    }
}
