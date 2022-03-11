

public class UpdatingEmployee {
    Employee employee;
    public UpdatingEmployee(String employeeName,int salary,int bonus) {

        try {
            Employee employee = new Employee();
            employee.setName(employeeName);
            employee.setSalary(salary);
            employee.setBonus(bonus);
            this.employee=employee;
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println("ERROR OCCURED");
        }
    }

    public Employee getEmployee() {
        return employee;
    }
}
