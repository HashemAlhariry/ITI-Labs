package gov.iti.backend.dto;



import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeDto {

    private int id;
    private String department;
    private String firstName;
    private String age;

    public EmployeeDto(int id, String department, String firstName, String age) {
        this.id = id;
        this.department = department;
        this.firstName = firstName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public EmployeeDto() {
    }
}
