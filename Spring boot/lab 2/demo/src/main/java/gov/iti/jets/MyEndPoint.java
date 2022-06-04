package gov.iti.jets;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "endpoint" ,enableByDefault = true)
public class MyEndPoint {
    private String text="TEXT";
    @ReadOperation
    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text=text;
    }
}
