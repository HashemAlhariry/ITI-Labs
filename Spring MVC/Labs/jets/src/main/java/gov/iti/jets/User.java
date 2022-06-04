package gov.iti.jets;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class User {


    @NotNull
    private String name;
    @Min(value = 20, message = "Salary is less than min")
    @Max(value = 20000, message = "Salary more than max")
    @NotNull
    private String salary;
    @Digits(integer = 2, fraction = 0)
    private int age;
    public User(String name, String salary,int age) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }
}
