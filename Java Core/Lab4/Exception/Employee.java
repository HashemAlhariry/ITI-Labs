

public class Employee {

    int bonus;
    int salary;
    String name;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) throws MyException {
        if(bonus>10){
            throw new MyException("TO MUCH BONUS");
        }
        this.bonus = bonus;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) throws MyException {
        if(salary>40000){
            throw new MyException("SALARY OVERLIMIT");
        }
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws MyException {
        if(name.length()>10){
            throw new MyException("MORE THAN 10 CHARACTERS");
        }
        this.name = name;
    }

}
