package gov.iti.jets;


import gov.iti.jets.bean.Department;
import gov.iti.jets.bean.Employee;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.registerShutdownHook();


        Department department  =(Department) context.getBean("departmentID");
        System.out.println("Department name String = "+department.getName());
        System.out.println("Department`s Employee size = " + department.getDepartmentDetails().getName());

        System.out.println("---------------");

        Employee employeeIDTest1  =(Employee) context.getBean("employeeIDTest1");
        System.out.println("Employee name string = " +employeeIDTest1.getName());
        System.out.println("Employee id int = " +employeeIDTest1.getId());

        System.out.println("---------------");

        Employee employeeIDTest2  =(Employee) context.getBean("employeeFactoryMethod");
        System.out.println("Employee name string = " +employeeIDTest2.getName());
        System.out.println("Employee id int = " +employeeIDTest2.getId());

        System.out.println("---------------");


        Department departmentTest1  =(Department) context.getBean("departmentTest2");
        System.out.println("Employee name string = " +departmentTest1.getName());
        System.out.println("Employee id int = " +departmentTest1.getDepartmentDetails().getName());

        System.out.println("---------------");


       // ClassA classA = (ClassA) factory.getBean("classAID");


    }

}
