package gov.iti.backend.services.impl;

import gov.iti.backend.exceptions.MyException;
import gov.iti.backend.repos.EmployeeRepo;
import gov.iti.backend.repos.entities.EmployeeEntity;
import gov.iti.backend.services.EmployeeService;
import jakarta.jws.WebService;
import java.math.BigDecimal;

@WebService(endpointInterface = "gov.iti.backend.services.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private  EmployeeRepo employeeRepo =  EmployeeRepo.getInstance();

    public void testException() throws MyException {
        throw  new MyException();
    }
    @Override
    public EmployeeEntity registerEmployee(EmployeeEntity employeeEntity) {

            employeeRepo.addEmployee(employeeEntity);
            return employeeEntity;
    }

    @Override
    public BigDecimal showAccountDetails(String userName, String password) throws MyException  {

        try{
            EmployeeEntity employeeEntity = employeeRepo.findEmployeeByUserNamePassword(userName);
            if(employeeEntity!= null && employeeEntity.getPassword().equals(password)){
                return employeeEntity.getAccountEntity().getAccountLimit();
            }
        }catch (Exception e){
            throw new MyException();
        }
       return null;

    }


    public String transferAmount(String userName, String password, String otherUserName, BigDecimal amount) throws MyException{
       try {
           EmployeeEntity employeeEntity =  employeeRepo.findEmployeeByUserNamePassword(userName);
           if(employeeEntity != null && employeeEntity.getPassword().equals(password) && employeeEntity.getAccountEntity().getAccountLimit().compareTo(amount)==1){
               EmployeeEntity employeeEntityToTransfer = employeeRepo.findEmployeeByUserNamePassword(otherUserName);
               if(employeeEntityToTransfer!= null){
                   employeeEntity.getAccountEntity().setAccountLimit( employeeEntity.getAccountEntity().getAccountLimit().subtract(amount));
                   employeeEntityToTransfer.getAccountEntity().setAccountLimit(employeeEntityToTransfer.getAccountEntity().getAccountLimit().add(amount));
                   employeeRepo.update(employeeEntity);
                   employeeRepo.update(employeeEntityToTransfer);
                   return "Transaction completed";
               }

           }
       }catch (Exception e){
           throw new MyException();
       }

        return "Some thing went wrong";
    }


}
