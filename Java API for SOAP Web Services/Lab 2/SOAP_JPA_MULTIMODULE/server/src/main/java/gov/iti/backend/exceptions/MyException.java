package gov.iti.backend.exceptions;

import jakarta.xml.ws.WebFault;

@WebFault
public class MyException extends  Exception {

    public MyException() {
        super("Your User name or password is wrong");
    }
}
