package gov.iti.backend;


import gov.iti.backend.dto.EmployeeDto;
import gov.iti.backend.repos.dbconnector.Connector;
import gov.iti.backend.repos.entities.AccountEntity;
import gov.iti.backend.repos.entities.EmployeeEntity;
import gov.iti.backend.services.EmployeeService;
import gov.iti.backend.services.impl.EmployeeServiceImpl;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import net.bytebuddy.implementation.bytecode.Throw;

import java.math.BigDecimal;

public class RunBackEnd
{
    public static void main( String[] args ) throws Exception {




        AccountEntity accountEntity = new AccountEntity(BigDecimal.valueOf(2000));
        AccountEntity accountEntity1 = new AccountEntity(BigDecimal.valueOf(4000));

        EmployeeEntity employeeEntity = new EmployeeEntity( "HASHEM","24",accountEntity);
        EmployeeEntity employeeEntity1 = new EmployeeEntity( "ASHRAF","60",accountEntity1);


        EmployeeService employeeService = new EmployeeServiceImpl();
        try {
            employeeService.showAccountDetails("hashem","24");
        } catch (Exception e) {
            throw  new Exception();
        }
        employeeService.transferAmount("HASHEM","24","ASHRAF", BigDecimal.valueOf(1000));

        //        EmployeeDto employeeDto= new EmployeeDto(13,"Fresh","HASHEM","52");
        //        EntityManager entityManager = Connector.getInstance().getEntityManager();
        //        entityManager.getTransaction().begin();
        //        entityManager.persist(employeeEntity);
        //        entityManager.persist(employeeEntity1);
        //        entityManager.persist(employeeEntity2);
        //        entityManager.persist(employeeEntity3);
        //        entityManager.persist(employeeEntity4);
        //        entityManager.getTransaction().commit();



    }
}
