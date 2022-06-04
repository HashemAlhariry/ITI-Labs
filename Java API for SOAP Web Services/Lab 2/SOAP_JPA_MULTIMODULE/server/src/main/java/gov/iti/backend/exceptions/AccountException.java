package gov.iti.backend.exceptions;


import jakarta.xml.ws.WebFault;

@WebFault
public class AccountException  extends  Exception {
    public AccountException() {
        super("Your User name or password is wrong");
    }
}
