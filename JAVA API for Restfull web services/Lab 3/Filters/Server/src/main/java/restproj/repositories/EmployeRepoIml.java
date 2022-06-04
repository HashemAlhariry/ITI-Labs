package restproj.repositories;

import java.util.ArrayList;
import java.util.List;

import restproj.entites.Department;
import restproj.entites.Employee;

public class EmployeRepoIml {

    private static final EmployeRepoIml INSTANCE = new EmployeRepoIml();
    public static List<Employee> employees;
    public static List<Department> departments;
    public static EmployeRepoIml getInstance() {
        return INSTANCE;
    }

    static {
        
        employees= new ArrayList<>();
        departments = new ArrayList<>();
        Department departmentQA = new Department("QA",1);
        Department departmentDivTeam =new Department("Developer",2);  

        departments.add(departmentQA);
        departments.add(departmentDivTeam);
        
        employees.add(new Employee(1, "Hashem", "Alhariry", 24,departmentQA));
        employees.add(new Employee(2, "Hazoma", "Alhariry", 45,departmentQA));
        employees.add(new Employee(3, "Said", "Alhariry", 13,departmentQA));
        employees.add(new Employee(4, "Khaled", "Said", 25,departmentDivTeam));
        employees.add(new Employee(5, "Ahmed", "Ashraf", 57,departmentDivTeam));
        employees.add(new Employee(6, "ferno", "Elfarnwani", 18,departmentDivTeam));
        employees.add(new Employee(7, "Hosso", "Atef", 38,departmentQA));
        employees.add(new Employee(8, "Megz", "Lolo", 31,departmentDivTeam));
    }

    
    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public List<Employee> getEmployees(){
            return employees;
    }

    public Employee getEmployeeWithId(int id) {
        for (Employee employee : employees) {
            if(employee.getId()==id)
                return employee;
        }
        return null;
    }


    public void deleteEmployee(int id) {
        employees.removeIf((Employee a) -> a.getId() == 2);
    }

    public void deleteAllEmployee() {
        employees.removeAll(employees);
    }

    public void updateEmployee(int id, Employee employee) {
        for (Employee emp : employees) {
            if(emp.getId()==id) {
                employees.remove(emp);
                employees.add(employee);
            } 
        }
    }

}
