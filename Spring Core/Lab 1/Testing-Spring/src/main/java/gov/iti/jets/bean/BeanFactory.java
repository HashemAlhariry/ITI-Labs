package gov.iti.jets.bean;

public class BeanFactory {

    public static Employee createEmployee(){
        return new Employee();
    }

    public static Department createDepartment(){
        return new Department();
    }


    public Department createDepartment(String name ,DepartmentDetails departmentDetails){
        return new Department(departmentDetails,name);
    }
}
