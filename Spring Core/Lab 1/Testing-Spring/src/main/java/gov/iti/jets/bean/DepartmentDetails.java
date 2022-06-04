package gov.iti.jets.bean;

public class DepartmentDetails {

    private String name;
    private String id;
    private String numberOfEmployees;

    public DepartmentDetails(String name, String id, String numberOfEmployees) {
        this.name = name;
        this.id = id;
        this.numberOfEmployees = numberOfEmployees;
    }

    public DepartmentDetails() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
