package prepbatching;

public class Employee {

    int id;
    String fname;
    String lname;
    int sex;
    int age;
    String address;
    String phoneNumber;
    int vacationBalance;

    public Employee(int id, String fname, String lname, int sex, int age, String address, String phoneNumber, int vacationBalance) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.vacationBalance = vacationBalance;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getVacationBalance() {
        return vacationBalance;
    }
}
