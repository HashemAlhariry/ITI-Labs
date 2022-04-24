package my.javabrains;


public class MessageDto {
    
    private String name;
    private String message;

    public MessageDto() {

    }
    
    public String getName() {
        return name;
    }

    public MessageDto(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
