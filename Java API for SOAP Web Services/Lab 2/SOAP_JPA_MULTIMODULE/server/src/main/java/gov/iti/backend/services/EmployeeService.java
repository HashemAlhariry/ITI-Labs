package gov.iti.backend.services;


import gov.iti.backend.exceptions.MyException;
import gov.iti.backend.repos.entities.EmployeeEntity;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.math.BigDecimal;

@WebService
public interface EmployeeService {

    @WebMethod
    public EmployeeEntity registerEmployee(EmployeeEntity employeeEntity);

    @WebMethod
    public BigDecimal showAccountDetails(String userName,String password) throws MyException;

    @WebMethod
    public String transferAmount(String userName, String password, String otherUserName, BigDecimal amount) throws MyException;

    public void testException() throws MyException;
}
