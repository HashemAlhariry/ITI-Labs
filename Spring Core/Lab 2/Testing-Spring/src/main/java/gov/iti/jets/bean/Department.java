package gov.iti.jets.bean;


public class Department {

    private DepartmentDetails departmentDetails;
    private String name;


    public Department() {
    }

    public Department( DepartmentDetails departmentDetails, String name) {
        this.departmentDetails = departmentDetails;
        this.name = name;
    }

    public DepartmentDetails getDepartmentDetails() {
        return departmentDetails;
    }

    public void setDepartmentDetails(DepartmentDetails departmentDetails) {
        this.departmentDetails = departmentDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
