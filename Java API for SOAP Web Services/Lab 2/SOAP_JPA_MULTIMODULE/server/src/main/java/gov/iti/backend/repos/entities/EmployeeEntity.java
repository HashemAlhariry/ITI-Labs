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

    private String firstName;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountEntity accountEntity;

    public EmployeeEntity(String firstName, String password) {
        this.firstName = firstName;
        this.password = password;
    }

    public EmployeeEntity(String firstName, String password, AccountEntity accountEntity) {
        this.firstName = firstName;
        this.password = password;
        this.accountEntity = accountEntity;
    }

    public EmployeeEntity() {

    }

}
