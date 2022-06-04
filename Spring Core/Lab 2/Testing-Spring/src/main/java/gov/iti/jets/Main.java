package gov.iti.jets;


import gov.iti.jets.bean.BasicDataSource;
import gov.iti.jets.bean.Department;
import gov.iti.jets.bean.Employee;
import gov.iti.jets.bean.scopes.UserPrototype;
import gov.iti.jets.bean.scopes.UserSingleton;
import gov.iti.jets.bean.wiringbyname.ClassA;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.registerShutdownHook();

        /*** DataSource ***/
        BasicDataSource basicDataSource  =(BasicDataSource) context.getBean("myDataSource");
        System.out.println("/*** DataSource ***/");
        System.out.println("DataSource username String = "+basicDataSource.getUserName());
        System.out.println("DataSource password String = " + basicDataSource.getPassword());
        System.out.println("---------------");


        /*** idref ***/
        Department department = (Department) context.getBean("department");
        System.out.println("/*** idref ***/");
        System.out.println("idref department department-details name String = "+department.getDepartmentDetails().getName());
        System.out.println("idref DataSource password String = " + department.getName());
        System.out.println("---------------");


        /*** Collections ***/
        Employee employee = (Employee) context.getBean("employeeAddressesList");
        System.out.println("/*** Collections ***/");
        System.out.println("Collections employee name String = "+employee.getName());
        System.out.println("Collections employee id String = "+employee.getId());
        System.out.println("Collections employee address size int = " + employee.getAddresses().size());
        System.out.println("---------------");


        /*** AutoWiring by name ***/
        ClassA classA = (ClassA) context.getBean("classA");
        System.out.println("/*** AutoWiring by name ***/");
        System.out.println("AutoWiring by name ClassA having autowired with ClassB bean ... "+ classA.getClassB().getName());
        System.out.println("---------------");


        /*** AutoWiring by type ***/
        gov.iti.jets.bean.wiringbytype.ClassA classAType = (gov.iti.jets.bean.wiringbytype.ClassA) context.getBean("classAType");
        System.out.println("/*** AutoWiring by type ***/");
        System.out.println("AutoWiring by name ClassA having autowired with ClassB bean ... "+ classAType.getClassBType().getName());
        System.out.println("---------------");

        /*** Singleton ***/
        UserSingleton userSingleton1 = (UserSingleton) context.getBean("userSingleton");
        System.out.println("/*** Singleton ***/");
        System.out.println("Singleton userSingleton1 ... "+ userSingleton1 );
        UserSingleton userSingleton2 = (UserSingleton) context.getBean("userSingleton");
        System.out.println("Singleton userSingleton2 ... "+ userSingleton2 );
        System.out.println("---------------");

        /*** Prototype ***/
        UserPrototype userPrototype1 = (UserPrototype) context.getBean("userPrototype");
        System.out.println("/*** Prototype ***/");
        System.out.println("Prototype userPrototype1 ... "+ userPrototype1 );
        UserPrototype userPrototype2 = (UserPrototype) context.getBean("userPrototype");
        System.out.println("Singleton userPrototype2 ... "+ userPrototype2 );
        System.out.println("---------------");


        context.close();
    }

}
