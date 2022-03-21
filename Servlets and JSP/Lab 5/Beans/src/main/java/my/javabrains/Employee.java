package my.javabrains;

public class Employee {

   public String username;
   public String departmentName;
   public String age;
   public String salary;

   public Employee(String userName, String departmentName, String age, String salary) {
      this.username = userName;
      this.departmentName = departmentName;
      this.age = age;
      this.salary = salary;

   };

   public Employee() {

   }

   public String getUsername() {
      return (username);
   }

   public void setUsername(String userName) {
      this.username = userName;
   }

   public String getDepartmentName() {
      return (departmentName);
   }

   public void setDepartmentName(String departmentName) {
      this.departmentName = departmentName;
   }

   public String getAge() {
      return (age);
   }

   public void setAge(String age) {
      this.age = age;
   }

   public String getSalary() {
      return (salary);
   }

   public void setSalary(String salary) {
      this.salary = salary;
   }
}
