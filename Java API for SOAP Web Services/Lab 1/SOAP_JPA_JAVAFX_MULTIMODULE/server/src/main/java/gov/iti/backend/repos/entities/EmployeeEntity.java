package gov.iti.backend.repos.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String department;
    private String firstName;
    private String age;

    public EmployeeEntity(String department, String firstName, String age) {
        this.department = department;
        this.firstName = firstName;
        this.age = age;
    }

    public EmployeeEntity() {

    }

}
