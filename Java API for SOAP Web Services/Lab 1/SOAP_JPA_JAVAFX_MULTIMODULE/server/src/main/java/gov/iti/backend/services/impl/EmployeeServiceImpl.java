package gov.iti.backend.services.impl;

import gov.iti.backend.dto.EmployeeDto;
import gov.iti.backend.repos.EmployeeRepo;
import gov.iti.backend.repos.entities.EmployeeEntity;
import gov.iti.backend.services.EmployeeService;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "gov.iti.backend.services.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {


    public  String testing(){
        return "Testing Function";
    }

    public List<EmployeeDto> getAllEmployees(){
       List<EmployeeEntity>employeeEntities= EmployeeRepo.getInstance().findAll();
        List<EmployeeDto> employeesDto = new ArrayList<>();
        for (EmployeeEntity employeeEntity:employeeEntities) {
            EmployeeDto employeeDto = new EmployeeDto(employeeEntity.getId(),employeeEntity.getDepartment(),employeeEntity.getFirstName(),employeeEntity.getAge());
                employeesDto.add(employeeDto);
        }

        return employeesDto;
    }

    public void updateEmployee(EmployeeDto employeeDto){
        EmployeeEntity employeeEntity=  EmployeeRepo.getInstance().findById(employeeDto.getId());

        if(employeeEntity!=null){
            employeeEntity.setAge(employeeDto.getAge());
            employeeEntity.setDepartment(employeeDto.getDepartment());
            employeeEntity.setFirstName(employeeDto.getFirstName());
            EmployeeRepo.getInstance().update(employeeEntity);
        }
    }

    public void deleteEmployee(int id){
       EmployeeEntity employeeEntity=  EmployeeRepo.getInstance().findById(id);
       if(employeeEntity!=null){
           EmployeeRepo.getInstance().delete(employeeEntity);
       }

    }


}
