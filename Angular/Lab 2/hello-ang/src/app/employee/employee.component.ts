import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})


export class EmployeeComponent implements OnInit {

      firstName: string = "Hashem";
      lastName:string  = "Alhariry";
      age : number = 24;


      //Array of employees
      arrEmployee:EmployeeComponent[]=[];

      constructor() { 
    
      }

      ngOnInit(): void {
        console.log("Init method from employee");
      }

      add(firstName:string,lastName:string,age:number){

          let employee = new EmployeeComponent();
          employee.setFirstName(firstName);
          employee.setLastName(lastName);
          employee.setAge(age);

          this.arrEmployee.push(employee);

      }

      /*** SETTERS AND GETTERS ***/

      getFirstName():string{
        return this.firstName;
      }

      setFirstName(firstName:string):void{
          this.firstName=firstName;
      }

      setLastName(lastName:string):void{
        this.lastName=lastName;
      }

      getFullName():string{
        return this.firstName+' '+this.lastName;
      }

      getTotalNumber():number{
        return this.arrEmployee.length;
      }
      
      setAge(age:number):void{
        this.age=age;
      }

      getAge():number{
        return this.age;
      }
      
      deleteEmployee(index:number):void{
        this.arrEmployee.splice(index, 1);
      }
}
