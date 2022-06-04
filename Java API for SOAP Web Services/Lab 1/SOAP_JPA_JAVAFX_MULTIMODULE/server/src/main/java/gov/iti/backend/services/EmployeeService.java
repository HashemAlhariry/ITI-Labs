package gov.iti.backend.services;

import gov.iti.backend.dto.EmployeeDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface EmployeeService {

    @WebMethod
    public  String testing();

    @WebMethod
    public List<EmployeeDto> getAllEmployees();

    @WebMethod
    public void updateEmployee(EmployeeDto employeeDto);

    @WebMethod
    public void deleteEmployee(int id);
}
