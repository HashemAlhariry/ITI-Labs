package gov.iti.backend;


import gov.iti.backend.dto.EmployeeDto;
import gov.iti.backend.repos.dbconnector.Connector;
import gov.iti.backend.repos.entities.EmployeeEntity;
import gov.iti.backend.services.EmployeeService;
import gov.iti.backend.services.impl.EmployeeServiceImpl;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

public class RunBackEnd
{
    public static void main( String[] args ){


        EmployeeEntity employeeEntity = new EmployeeEntity("JAVA","HASHEM","24");
        EmployeeEntity employeeEntity1 = new EmployeeEntity("JAVA","ASHRAF","60");
        EmployeeEntity employeeEntity2 = new EmployeeEntity("QA","MOHAMMED","19");
        EmployeeEntity employeeEntity3 = new EmployeeEntity("TESTING","HANY","40");
        EmployeeEntity employeeEntity4 = new EmployeeEntity("MOBILE","FADY","30");

        EmployeeDto employeeDto= new EmployeeDto(13,"Fresh","HASHEM","52");

        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.updateEmployee(employeeDto);

        //        EntityManager entityManager = Connector.getInstance().getEntityManager();
        //
        //        entityManager.getTransaction().begin();
        //        entityManager.persist(employeeEntity);
        //        entityManager.persist(employeeEntity1);
        //        entityManager.persist(employeeEntity2);
        //        entityManager.persist(employeeEntity3);
        //        entityManager.persist(employeeEntity4);
        //        entityManager.getTransaction().commit();


    }
}
