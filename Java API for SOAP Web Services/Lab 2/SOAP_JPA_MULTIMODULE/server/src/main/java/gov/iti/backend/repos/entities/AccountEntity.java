package gov.iti.backend.repos.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class AccountEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private BigDecimal accountLimit;

    @OneToOne(mappedBy = "accountEntity")
    private EmployeeEntity employeeEntity;

    public AccountEntity(BigDecimal accountLimit) {
        this.accountLimit = accountLimit;
    }

    public AccountEntity() {

    }


}
